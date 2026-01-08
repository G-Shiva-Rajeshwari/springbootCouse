package com.gsrr.TaskManagement.user.dto;

import lombok.Getter;
import lombok.Setter;

public record UserUpdateRequest (
	String name,String email
) {
}
