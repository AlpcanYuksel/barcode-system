package com.barcode.dto;

import com.barcode.core.utilities.exceptions.Messages;

import lombok.Data;

@Data
public class SuccessResponse {

	private String message = Messages.SUCCESSFULLY;
}
