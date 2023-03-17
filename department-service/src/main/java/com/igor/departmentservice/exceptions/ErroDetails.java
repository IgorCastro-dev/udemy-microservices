package com.igor.departmentservice.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroDetails {
	private LocalDateTime timesTamp;
	private String message;
	private String path;
	private String erroCode;
}
