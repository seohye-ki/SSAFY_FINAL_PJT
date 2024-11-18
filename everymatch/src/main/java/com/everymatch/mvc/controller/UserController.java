package com.everymatch.mvc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everymatch.mvc.model.dto.User;
import com.everymatch.mvc.model.service.UserService;
import com.everymatch.mvc.util.JwtUtil;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final UserService userService;
	
	private final JwtUtil jwtUtil;
	
	public UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}
	
	//회원가입
	@PostMapping("/regist")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
			if(userService.isDuplicateId(user.getUserId()))
				return new ResponseEntity<>("이미 존재하는 아이디", HttpStatus.CONFLICT);
			if(userService.isDuplicateEmail(user.getEmail()))
				return new ResponseEntity<>("이미 존재하는 이메일", HttpStatus.CONFLICT);
			userService.registerUser(user);
			return new ResponseEntity<>("회원가입 성공", HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>("회원가입 에러 발생", HttpStatus.BAD_REQUEST);
		}
	}
	
	//로그인
	@PostMapping("/login")
	public ResponseEntity<HashMap<String, Object>> login(@RequestParam String userId, @RequestParam String password) {
		
		HashMap<String, Object> result = new HashMap<>();
		if(userService.loginUser(userId, password)) {
			result.put("message", "로그인 성공");
			result.put("access-token", jwtUtil.createToken("userId", userId));
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		else
			result.put("message", "로그인 실패");
		return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
	   
	}
	
	//마이페이지 - 회원정보 상세
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = userService.getUserDetails(userId);
		if (user != null) {
            User userResponse = new User(user.getUserId(), user.getNickname(), user.getEmail(), user.getUserImg());
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//회원정보 수정
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestParam String nickname, @RequestParam String email) {
		if(nickname == null || email == null || userService.isDuplicateEmail(email))
			return new ResponseEntity<>("변경불가", HttpStatus.BAD_REQUEST);
		userService.updateUser(userId, nickname, email);
		return new ResponseEntity<>("업데이트 성공", HttpStatus.OK);
	}
	
	//비밀번호 수정
	@PutMapping("/update-password")
	public ResponseEntity<String> updatePassword(@RequestParam String userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
		if(userService.updatePassword(userId, oldPassword, newPassword))
            return new ResponseEntity<>("비밀번호 변경 성공", HttpStatus.OK);
        return new ResponseEntity<>("비밀번호 변경 실패", HttpStatus.BAD_REQUEST);
	}
	
	//회원탈퇴
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		if(userService.deleteUser(userId))
			return new ResponseEntity<>("유저 삭제 성공", HttpStatus.OK);
		return new ResponseEntity<>("유저 삭제 실패", HttpStatus.BAD_REQUEST);		
	}

	//아이디 중복체크
	@PostMapping("/check/id")
	public ResponseEntity<String> checkId(@RequestParam String userId) {
		if(userService.isDuplicateId(userId))
			return new ResponseEntity<>("아이디 중복", HttpStatus.CONFLICT);
		return new ResponseEntity<>("사용가능 아이디", HttpStatus.OK);
	}

	//이메일 중복체크
	@PostMapping("/check/email")
	public ResponseEntity<String> checkEmail(@RequestParam String email) {
        if(userService.isDuplicateEmail(email))
        	return new ResponseEntity<>("이메일 중복", HttpStatus.CONFLICT);
    	return new ResponseEntity<>("사용가능 이메일", HttpStatus.OK);
    }
}
