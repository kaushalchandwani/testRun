/**
 * @author Kaushal Chandwani
 *
 */
package com.cucumber.config;


public class Constant 
{
	public static final String env_variable = "dev2";

	public static final String url_nhsAccountCreation = "https://keycloak."+env_variable+".signin.nhs.uk/cicauth/realms/NHS/account/dashboard";
	public static final String url_nhsAccountRealmAdmin = "https://keycloak."+env_variable+".signin.nhs.uk/cicauth/admin/NHS/console";
	public static final String environmentVariable = "local";
	//public static final String environmentVariable = "remote";

	public static final String url__mailCatcher_local = "https://mail."+env_variable+".signin.nhs.uk/";
	public static final String url__mailCatcher_remote = "http://172.17.0.1:1080";
	public static final String username_realmAdmin = "realmadmin";
	public static final String password_realmAdmin = "Welcome123";
	public static final String username_Patient = "cid.testuser3@gmail.com"; 
	public static final String password_Patient = "Welcome123#";
	public static final String new_password_Patient = "Backtologin123#"; 
	
	public static final String path_test_data ="src/test/resources/";
	
	public static final String xpath_loginPage_header =".//*[@id='content']/div/div/div[1]/div/form/fieldset/h1/legend";
	public static final String xpath_loginPage_EmailInputBox = ".//*[@id='username']";
	public static final String xpath_loginPage_PasswordInputBox = ".//*[@id='password']";
	public static final String xpath_loginPage_loginButton = ".//*[@id='kc-login']";
	public static final String xpath_loginPage_registerLink = ".//*[@id='content']/div/div/div[1]/div/div/div/p/a/label";
	public static final String xpath_loginPage_logOutBanner = ".//*[@id='content']/div/div/div[1]/div/div[1]/div";
	public static final String xpath_loginPage_forgotPasswordLink = ".//*[@id='content']/div/div/div[1]/div/form/p/a";
	public static final String xpath_loginPage_resetPasswordLinkBanner = ".//*[@id='content']/div/div/div[1]/div/div[1]/p";
	public static final String xpath_loginPage_fogottenPasswordHeader = ".//*[@id='content']/div/div/div[1]/div/div[1]/h3";
	public static final String xpath_loginPage_checkEmailBanner = ".//*[@id='content']/div/div/div[1]/div/div[1]/h2";
	public static final String xpath_loginPage_emailVerificationBanner = ".//*[@id='content']/div/div/div[1]/div/div[1]/div";
	public static final String xpath_loginPage_validationMessageBanner = ".//*[@id='content']/div/div/div[1]/div/div[1]/div";
	
	public static final String xpath_registerPage_EmailInputBox = ".//*[@id='email']";
	public static final String xpath_registerPage_PasswordInputBox = ".//*[@id='password']";
	public static final String xpath_registerPage_confirmPasswordInputBox = ".//*[@id='password-confirm']";
	public static final String xpath_registerPage_registerButton = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/fieldset/input";
	public static final String xpath_registerPage_passwordRules = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/div[2]/ul";
	public static final String xpath_registerPage_backToSignInLink = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/fieldset/p/a";
	
	public static final String xpath_confirmEmailPage_messageBanner = ".//*[@id='content']/div/div/div[1]/div/div[1]/div";
	public static final String xpath_confirmEmailPage_messageHeader = ".//*[@id='content']/div/div/div[1]/div/div[2]/h1";
	public static final String xpath_confirmEmailPage_resendEmailLink = ".//*[@id='content']/div/div/div[1]/div/div[2]/p[2]/a";
	public static final String xpath_confirmEmailPage_loginLink =".//*[@id='content']/div/div/div[1]/div/div[2]/p[3]/a";
	public static final String xpath_validateEmailPage3rdAttempt_messageBanner =".//*[@id='content']/div/div/div[1]/div/div/p[1]";
	public static final String xpath_validateEmailPage3rdAttempt_messageHeader =".//*[@id='content']/div/div/div[1]/div/div/h1/legend";
	public static final String xpath_validateEmailPage3rdAttempt_loginLink = ".//*[@id='content']/div/div/div[1]/div/div/p[2]/a";
	
	
	
	
	
	public static final String xpath_validateEmailExpirePage_messageBanner = ".//*[@id='content']/div/div/div[1]/div/div";
	public static final String xpath_validateEmailExpirePage_messageHeader = ".//*[@id='content']/div/div/div[1]/div/div/h1";
	public static final String xpath_validateEmailExpirePage_createAccountLink = ".//*[@id='content']/div/div/div[1]/div/p/a";
	
	
	public static final String xpath_dashboardPage_messageBanner = ".//*[@id='content']/div/div/div[1]/div/div/h1/legend";
	public static final String xpath_dashboardPage_userEmailId = ".//*[@id='content']/div/div/div[1]/div/div/p";
	public static final String xpath_dashboardPage_logoutLink = ".//*[@id='global-header']/div/div/p/a[3]";
	public static final String xpath_dashboardPage_accountUpdatedBanner = ".//*[@id='content']/div/div/div[1]/div/div/h1/legend";
	public static final String xpath_dashboardPage_accountLink = ".//*[@id='global-header']/div/div/p/a[2]";
	
	//Your account has been updated.
	
	public static final String xpath_mailcatcherTable = ".//*[@id='messages']/table/tbody";
	public static final String xpath_mailcatcherEmailContent = "html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span";
	public static final String xpath_mailcatcherEmailHtmlTab = ".//*[@id='message']/header/nav/ul/li[1]/a";
	public static final String xpath_mailcatcheriframe = "iframe";
	public static final String xpath_mailcatcherVerifyButton = "html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span/a[1]";
	public static final String xpath_mailcatcherVerifyLink = "html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span/a[2]";
	public static final String xpath_mailcatcherResetPasswordButton = "html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span/a";
	public static final String xpath_mailcatcherResetPasswordLink = "html/body/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/span/strong/a";
	
	public static final String xpath_mailcatcherOTPPlainTextTab = ".//*[@id='message']/header/nav/ul/li[2]/a";
	public static final String xpath_mailcatcherOTPContent = "xhtml:html/xhtml:body";
	public static final String xpath_mailcatcherOTPiframe = "iframe";

	
	public static final String xpath_forgotPasswordPage_header = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/h1/legend";
	public static final String xpath_forgotPasswordPage_banner = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/p/label";
	public static final String xpath_forgotPasswordPage_emailIdInputBox = ".//*[@id='username']";
	public static final String xpath_forgotPasswordPage_submitButton = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/div[2]/div[1]/input";
	public static final String xpath_forgotPasswordPage_backToSigninLink = ".//*[@id='content']/div/div/div[2]/div/form/fieldset/div[2]/div[2]/div/p/a";
	
	public static final String xpath_resetPasswordPage_label = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/h1/legend";
	public static final String xpath_resetPasswordPage_contents = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/div[1]";
	public static final String xpath_resetPasswordPage_newPasswordInputBox = ".//*[@id='password-new']";
	public static final String xpath_resetPasswordPage_retypePasswordInputBox = ".//*[@id='password-confirm']";
	public static final String xpath_resetPasswordPage_continueButton = ".//*[@id='content']/div/div/div[1]/div/form/input[3]";
	public static final String xpath_resetPasswordPage_bannerMessage = ".//*[@id='content']/div/div/div[1]/div/div/div";
	
	
	
	public static final String xpath_expiredResetPasswordPage_label =".//*[@id='content']/div/div/div[1]/div/div/h2";
	public static final String xpath_expiredResetPasswordPage_contents = ".//*[@id='content']/div/div/div[1]/div/div";
	public static final String xpath_expiredResetPasswordPage_backToLoginResetLink = "	.//*[@id='backToApplication']";
	

	
	public static final String xpath_otpCodePage_legend = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/h2";
	public static final String xpath_otpCodePage_content = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/p/label";
	public static final String xpath_otpCodePage_otpCodeInputBox = ".//*[@id='otp_entered']";
	public static final String xpath_otpCodePage_continueButton = ".//*[@id='content']/div/div/div[1]/div/form/fieldset/div[2]/div/input";
	public static final String xpath_otpCodePage_invalidOtpCodeError_resendMessage = ".//*[@id='content']/div/div/div[1]/div/div/div";
	public static final String xpath_otpCodePage_resendOtpLink = ".//*[@id='content']/div/div/div[1]/div/p/a";
	public static final String xpath_otpCodePage_resendOtpMessage = ".//*[@id='content']/div/div/div[1]/div/p/label";

	public static final String xpath_otpPhoneNoPage_phoneNoInputBox = ".//*[@id='mobile_number']";
	public static final String xpath_otpPhoneNoPage_pageContent = ".//*[@id='content']/div/div/div[2]/div/form/fieldset/p/label";
	public static final String xpath_otpPhoneNoPage_pagelegend = ".//*[@id='content']/div/div/div[2]/div/form/fieldset/h2";
	public static final String xpath_otpPhoneNoPage_submitButtion = ".//*[@id='content']/div/div/div[2]/div/form/fieldset/div[2]/div/input";
	public static final String xpath_otpPhoneNoPage_invalidPhoneNoError = ".//*[@id='content']/div/div/div[2]/div/div/div";

	public static final String xpath_accountInfoPage_header = ".//*[@id='content']/div/div/div[1]/div/div/h1/legend";
	public static final String xpath_accountInfoPage_backToApplicationLink = ".//*[@id='content']/div/div/div[1]/div/div/p[2]/a";
	
	//new static variables
	
	public static final String xpath_yourNhsNumberPage_header = ".//*[@id='content']/app-nhs-number/div/div[1]/div[1]/div/div/fieldset/label/h1";
	public static final String xpath_yourNhsNumberPage_nhsNoInputBox = ".//*[@id='nhs_number']";
	public static final String xpath_yourNhsNumberPage_validNhsNumberRules = ".//*[@id='content']/app-nhs-number/div/div[1]/div[1]/div/div/fieldset/div[2]/p";
	public static final String xpath_yourNhsNumberPage_continueButton = ".//*[@id='content']/app-nhs-number/div/div[1]/div[1]/div/div/fieldset/div[3]/a";
	public static final String xpath_yourNhsNumberPage_dontKnowNhsNumberLink = ".//*[@id='content']/app-nhs-number/div/div[1]/div[1]/div/div/fieldset/p/a";
		
	
	public static final String url_nhsStepUpPage = "http://pyi-temp-test.s3-website-eu-west-1.amazonaws.com/";
	
	public static final String url_yourNhsNumberPage = "http://pyi-temp-test.s3-website-eu-west-1.amazonaws.com/#/pages/nhs-number";
	
	public static final String url_sorryCannotContinuePage = "http://pyi-temp-test.s3-website-eu-west-1.amazonaws.com/#/pages/unknown-nhs-number";
	
	public static final String invalid_nhs_no_error_message = ".//*[@id='nhs-number-error']";
	
	public static final String xpath_stepUpPage_option1MainHeader = ".//*[@id='content']/app-steps/div[2]/div[1]/div[1]/section/ol/app-step[1]/li/h3";
	
	public static final String xpath_stepUpPage_option2MainHeader = ".//*[@id='content']/div[2]/div[1]/div[1]/section/ol/li[2]/h3";
	public static final String xpath_stepUpPage_option2SubHeader = ".//*[@id='content']/app-steps/div[2]/div[1]/div[1]/section/ol/app-step[2]/li/div/p[1]";
	
	public static final String xpath_stepUpPage_option3MainHeader = ".//*[@id='content']/app-steps/div[2]/div[1]/div[1]/section/ol/app-step[3]/li/h3";
	public static final String xpath_stepUpPage_option3SubHeader = ".//*[@id='content']/app-steps/div[2]/div[1]/div[1]/section/ol/app-step[3]/li/div/p[1]";
	
	public static final String xpath_stepUpPage_option4MainHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-steps[1]/div[2]/div[1]/div[1]/section[1]/ol[1]/app-step[4]/li[1]/h3[1]";
	public static final String xpath_stepUpPage_option4SubHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-steps[1]/div[2]/div[1]/div[1]/section[1]/ol[1]/app-step[4]/li[1]/div[1]/p[1]";
	
	public static final String xpath_stepUpPage_option2StartButton = ".//*[@id='content']/app-steps/div[2]/div[1]/div[1]/section/ol/app-step[2]/li/a";
	public static final String xpath_stepUpPage_option1Completed = ".//*[@id='content']/app-steps/div[2]/div[1]/div[1]/section/ol/app-step[1]/li/span";
	
	public static final String xpath_stepUpPage_option2Completed = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-steps[1]/div[2]/div[1]/div[1]/section[1]/ol[1]/app-step[2]/li[1]/span[1]";
	
	public static final String xpath_sorryCannotContinuePage_MainHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-cannot-continue[1]/div[1]/div[1]/div[1]/div[1]/h1[1]";
	public static final String xpath_sorryCannotContinuePage_Content = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-cannot-continue[1]/div[1]/div[1]/div[1]/div[1]/p[1]";
	public static final String xpath_sorryCannotContinuePage_goBackLink = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-cannot-continue[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]";
	
	public static final String xpath_stepUpPage_option3StartButton = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-steps[1]/div[2]/div[1]/div[1]/section[1]/ol[1]/app-step[3]/li[1]/a[1]";
	
	public static final String xpath_photoIDDocumentPage_header="/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id[1]/div[1]/div[1]/div[1]/div[1]/div[2]/fieldset[1]/legend[1]/h1[1]";
	public static final String xpath_photoIDDocumentPage_passport_radiobutton="/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id[1]/div[1]/div[1]/div[1]/div[1]/div[2]/fieldset[1]/div[1]/label[1]";
	public static final String xpath_photoIDDocumentPage_drivinglicence_radiobutton="/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id[1]/div[1]/div[1]/div[1]/div[1]/div[2]/fieldset[1]/div[2]/label[1]";
	public static final String xpath_photoIDDocumentPage_neitherofthese_radiobutton = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id[1]/div[1]/div[1]/div[1]/div[1]/div[2]/fieldset[1]/div[3]/label[1]";
	public static final String xpath_photoIDDocumentPage_continueButton = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id[1]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]";
	public static final String xpath_photoIDDocumentPage_goBackLink = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]";
	public static final String url_photoIDDocumentPage = "http://pyi-temp-test.s3-website-eu-west-1.amazonaws.com/#/pages/photo-id-type";

	public static final String xpath_iDInstructionsPage_mainHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/legend[1]/h1[1]";
	public static final String xpath_iDInstructionsPage_subHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/p[1]";
	public static final String xpath_iDInstructionsPage_instruction1 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[1]";
	public static final String xpath_iDInstructionsPage_instruction2 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[2]";
	public static final String xpath_iDInstructionsPage_instruction3 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[3]";
	public static final String xpath_iDInstructionsPage_instruction4 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[4]";
	public static final String xpath_iDInstructionsPage_goBackLink = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/p[1]/a[1]";
	public static final String xpath_iDInstructionsPage_openCameraButton = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-photo-id-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/div[1]/button[1]";

	public static final String xpath_stepUpPage_option4StartButton = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-steps[1]/div[2]/div[1]/div[1]/section[1]/ol[1]/app-step[4]/li[1]/a[1]";
	
	
	
	public static final String xpath_videoSelfiePage_mainHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/legend[1]/h1[1]";
	public static final String xpath_videoSelfiePage_subHeader = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/p[1]";
	
	public static final String xpath_videoSelfiePage_instruction1 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[1]";
	public static final String xpath_videoSelfiePage_instruction2 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[2]";
	public static final String xpath_videoSelfiePage_instruction3 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[3]";
	public static final String xpath_videoSelfiePage_instruction4 = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/ul[1]/li[4]";
	
	public static final String xpath_videoSelfiePage_openCameraButton = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/fieldset[1]/div[1]/button[1]";
	public static final String xpath_videoSelfiePage_goBackLink = "/html[1]/body[1]/app-root[1]/app-layout[1]/main[1]/app-video-selfie-instructions[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/p[1]/a[1]";

//	patient online page variables
	public static final String urlPatientOnlinePage = "http://pyi.dev4.signin.nhs.uk/#/patient-online/linkage-key";

	public static final String xpath_PatientOnlinePage_linkageKeyNoInputBox = ".//*[@id='linkageKey']";
	public static final String xpath_PatientOnlinePage_odsCodeNoInputBox = ".//*[@id='ODSCode']";
	public static final String xpath_PatientOnlinePage_userIdNoInputBox = ".//*[@id='userID']";

	public static final String xpath_PatientOnlinePage_continueButton = ".//*[@id='continue']";

	public static final String xpath_PatientOnlinePage_nhsHeader = ".//*[@id='nhsHeader']";
	public static final String xpath_PatientOnlinePage_formHeader = ".//*[@id='formHeader']";

	public static final String xpath_PatientOnlinePage_linkageKeyLabel = ".//*[@id='linkageKeyLabel']";
	public static final String xpath_PatientOnlinePage_linkageKeyHint = ".//*[@id='linkageKeyHint']";
	public static final String linkageKeyErrorMessage_PatientOnlinePage = ".//*[@id='linkageKeyError']";

	public static final String xpath_PatientOnlinePage_odsCodeLabel = ".//*[@id='odsCodeLabel']";
	public static final String xpath_PatientOnlinePage_odsCodeHint = ".//*[@id='odsCodeHint']";
	public static final String odsCodeErrorMessage_PatientOnlinePage = ".//*[@id='odsCodeError']";

	public static final String xpath_PatientOnlinePage_userIDLabel = ".//*[@id='userIDLabel']";
	public static final String xpath_PatientOnlinePage_userIDHint = ".//*[@id='userIDHint']";
	public static final String userIDErrorMessage_PatientOnlinePage = ".//*[@id='userIDError']";
	
	public static final String xpath_PatientOnlinePage_validNhsNumberRules = ".//*[@id='content']/app-nhs-number/div/div[1]/div[1]/div/div/fieldset/div[2]/p";
}
