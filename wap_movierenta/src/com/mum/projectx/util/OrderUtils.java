package com.mum.projectx.util;

import java.util.UUID;

public class OrderUtils {
	
	public static String generateOrderNumber() {
		return  UUID.randomUUID().toString();
	}
}
