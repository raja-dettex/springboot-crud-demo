package utils;

import com.demo.dtos.UserRequestDto;
import com.demo.dtos.UserResponseDto;
import com.demo.models.User;

public class UserUtils {

	
	public static User userRequestToUser(UserRequestDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setTimestampAdded(System.currentTimeMillis());
		return user;
	}
	
	public static UserResponseDto userToUserResponse(User user) {
		UserResponseDto userResponseDto = new UserResponseDto(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getTimestampAdded());
		return userResponseDto;
	}
}
