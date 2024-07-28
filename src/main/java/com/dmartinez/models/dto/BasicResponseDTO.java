package com.dmartinez.models.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class BasicResponseDTO implements Serializable {

	private String response;

	private static final long serialVersionUID = 1L;

}
