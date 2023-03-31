package com.igor.departmentservice.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "departmentDto Model Information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
	private Long id;
	@Schema(description = "department Name")
	private String departmentName;
	
	@Schema(description = "Department Description")
	private String departmentDescription;
	
	@Schema(description = "Department Code")
	private String departmentCode;

}
