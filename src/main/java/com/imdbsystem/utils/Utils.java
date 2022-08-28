package com.imdbsystem.utils;

import java.security.Principal;

public class Utils {
	
	public Utils() {}
	
	public static boolean sessionStatus(Principal principal) {
		if (principal != null) {
			return true;
		} else {
			return false;
		}
	}

}
