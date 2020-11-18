package com.hope.Service;



import org.springframework.ui.ModelMap;

import com.hope.entities.ConfirmationToken;

public interface ConfirmationTokenService extends CrudEnties<ConfirmationToken> {
	public ConfirmationToken getConfirmationTokenByToken(String token);
	public boolean confirmToken(String token);
}
