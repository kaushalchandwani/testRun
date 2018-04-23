package com.cucumber.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.cucumber.config.Constant;
import com.cucumber.pageobjects.IDInstructionsPage;
import com.cucumber.pageobjects.PhotoIDPage;
import com.cucumber.pageobjects.SorryCannotContinuePage;
import com.cucumber.pageobjects.StepUpPage;
import com.cucumber.pageobjects.VideoSelfiePage;
import com.cucumber.pageobjects.YourNhsNumberPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NhsNumberEntry {
	public WebDriver driver;
//	@Before
//	public void before() 
//	{
//		System.out.println("\nOpening webdriver \n");
//		
//		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--start-maximized");
//		driver = new ChromeDriver(options);
//		/*if(Constant.environmentVariable.equalsIgnoreCase("local"))
//	  	{
//			System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe"); //chromedriver.exe set property path
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--start-maximized");
//			driver = new ChromeDriver(options);
//			//driver = new ChromeDriver();
//	  	}
//	  	else
//	  	{
//	  		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
//			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//			capabilities.setCapability("marionette", true);
//			driver = new FirefoxDriver(capabilities);
//	  	}  */  
//	}
//	 
//	@After
//	public void after() 
//	{
//		System.out.println("\nClosing webdriver......");
//		driver.get("about:config");
//		//driver.quit();
//		driver.close();
//	}

	//Accessing Step Up Page
	
	@Given("^the user has navigated to the prove your identity page$")
	public void the_user_has_navigated_to_the_prove_your_identity_page() throws Throwable {
		driver.get(Constant.url_nhsStepUpPage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		 
	}

	@Then("^step up page is displayed$")
	public void step_up_page_is_displayed() throws Throwable {
		new StepUpPage(driver).display_step_up_page();
	   
	}

	@Then("^first option of Create an NHS account is shown as Completed$")
	public void first_option_of_Create_an_NHS_account_is_shown_as_Completed() throws Throwable {
		new StepUpPage(driver).verify_create_nhs_account_status();
	    
	}

	@Then("^second option of Your NHS number has a clickable Start button$")
	public void second_option_of_Your_NHS_number_has_a_clickable_Start_button() throws Throwable {
		new StepUpPage(driver).verify_your_nhs_number_has_clickbale_start_button();
	    
	}
	
	//Accessing Your NHS Number Page
	
	@Given("^the user is on the step up page$")
	public void the_user_is_on_the_step_up_page() throws Throwable {
		driver.get(Constant.url_nhsStepUpPage);
		new StepUpPage(driver).display_step_up_page();
		Thread.sleep(4000);
	}

	@When("^user click on the Start button visible in the second option of step up page$")
	public void user_click_on_the_Start_button_visible_in_the_second_option_of_step_up_page() throws Throwable {
		new StepUpPage(driver).your_nhs_number_start_button();
	}

	@Then("^Your NHS number page is displayed$")
	public void your_NHS_number_page_is_displayed() throws Throwable {
	    new YourNhsNumberPage(driver).verify_your_nhs_number_page();
	    new YourNhsNumberPage(driver).verify_textBox_displayed();
	}
	
		
	//Accessing the Sorry you cannot continue page
	@Given("^the user is on the Your NHS number page$")
	public void the_user_is_on_the_Your_NHS_number_page() throws Throwable {
		driver.get(Constant.url_yourNhsNumberPage);
		Thread.sleep(3000);
	}

	@When("^the user clicks on I dont know my NHS number link$")
	public void the_user_clicks_on_I_dont_know_my_NHS_number_link() throws Throwable {
	    new YourNhsNumberPage(driver).user_dont_know_nhs_number_link();
	    Thread.sleep(1000);
	}

	@Then("^a page is displayed advising the user that they cant continue with the step up activities$")
	public void a_page_is_displayed_advising_the_user_that_they_cant_continue_with_the_step_up_activities() throws Throwable {
	    new SorryCannotContinuePage(driver).display_sorry_you_cannot_continue_page();
	}
	
	//Navigating Back to Your NHS number Page
	@Given("^the user is on the Sorry you cannot continue page$")
	public void the_user_is_on_the_Sorry_you_cannot_continue_page() throws Throwable {
	    driver.get(Constant.url_sorryCannotContinuePage);
	    Thread.sleep(1000);
	}

	@When("^the user click on the Go back link$")
	public void the_user_click_on_the_Go_back_link() throws Throwable {
	    new SorryCannotContinuePage(driver).verify_go_back_link();
	}

	@Then("^Your NHS Number Page is displayed$")
	public void your_NHS_Number_Page_is_displayed() throws Throwable {
	    new YourNhsNumberPage(driver).verify_your_nhs_number_page();
	}
	
	//Valid NHS number entry in the text box provided
		@Given("^the user is on the YOUR NHS number page$")
		public void the_user_is_on_the_YOUR_NHS_number_page() throws Throwable {
		    driver.get(Constant.url_yourNhsNumberPage);
		    Thread.sleep(3000);
		}

		@When("^user enters the \"([^\"]*)\" in the text box provided$")
		public void user_enters_the_in_the_text_box_provided(String arg1) throws Throwable {
		    new YourNhsNumberPage(driver).user_provides_the_nhs_number_as(arg1);
		    Thread.sleep(2000);
		}

		@When("^select continue$")
		public void select_continue() throws Throwable {
			new YourNhsNumberPage(driver).user_clicks_continue_button();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
		}

		@Then("^navigate to the step up page with second option of Your NHS number as Completed$")
		public void navigate_to_the_step_up_page_with_second_option_of_Your_NHS_number_as_Completed() throws Throwable {
			new StepUpPage(driver).verify_your_nhs_number_status();
				   
		}

		@Then("^third option of Photo ID document details has a clickable Start button$")
		public void third_option_of_Photo_ID_document_details_has_a_clickable_Start_button() throws Throwable {
		    new StepUpPage(driver).verify_photo_ID_document_details_has_clickbale_start_button();
		    Thread.sleep(2000);
		    }
		
	//Invalid NHS number entry in the text box provided
		@When("^user enters the invalid \"([^\"]*)\" in the text box provided$")
		public void user_enters_the_invalid_in_the_text_box_provided(String arg1) throws Throwable {
			driver.get(Constant.url_yourNhsNumberPage);
			Thread.sleep(1000);
			new YourNhsNumberPage(driver).user_provides_the_nhs_number_as(arg1);
			new YourNhsNumberPage(driver).user_clicks_continue_button();
    
}

		@Then("^an error message is displayed in the Your NHS number page$")
		public void an_error_message_is_displayed_in_the_Your_NHS_number_page() throws Throwable {
			new YourNhsNumberPage(driver).invalid_nhs_no_error_message();
		}
			
	//Photo ID Document - Display page
			@When("^the user clicks the start button next to third Option of Photo ID Document$")
			public void the_user_clicks_the_start_button_next_to_third_Option_of_Photo_ID_Document() throws Throwable {
				driver.get(Constant.url_nhsStepUpPage);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				new StepUpPage(driver).your_nhs_number_start_button();
				Thread.sleep(2000);
				new YourNhsNumberPage(driver).user_provides_the_nhs_number_as("1234567890");
				Thread.sleep(1000);
				new YourNhsNumberPage(driver).user_clicks_continue_button();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				new StepUpPage(driver).verify_photo_ID_document_details_has_clickbale_start_button();
				Thread.sleep(1000);
				new StepUpPage(driver).photo_id_document_start_button();
				Thread.sleep(1000);
			
			}

			@Then("^What type of photo ID do you have page is displayed$")
			public void what_type_of_photo_ID_do_you_have_page_is_displayed() throws Throwable {
				new PhotoIDPage(driver).verify_photo_id_document_page();
			    Thread.sleep(1000);
			}
			
	//Back link in PhotoID Document Page
			
			@Given("^the user is on the What type of photo ID do you have page$")
			public void the_user_is_on_the_What_type_of_photo_ID_do_you_have_page() throws Throwable{
				driver.get(Constant.url_nhsStepUpPage);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				new StepUpPage(driver).your_nhs_number_start_button();
				Thread.sleep(2000);
				new YourNhsNumberPage(driver).user_provides_the_nhs_number_as("1234567890");
				Thread.sleep(1000);
				new YourNhsNumberPage(driver).user_clicks_continue_button();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(2000);
				new StepUpPage(driver).verify_photo_ID_document_details_has_clickbale_start_button();
				Thread.sleep(1000);
				new StepUpPage(driver).photo_id_document_start_button();
				Thread.sleep(1000);
			}	
			   

			@When("^the user clicks on the Go back link$")
			public void the_user_clicks_on_the_Go_back_link() throws Throwable {
			    new PhotoIDPage(driver).back_link();
			    Thread.sleep(1000);
			}

			@Then("^display the step up page$")
			public void display_the_step_up_page() throws Throwable {
				Assert.assertEquals(driver.getTitle(),"NHS - Citizen ID");
					   
			}
			
			@Then("^third option has a visible start option$")
			public void third_option_has_a_visible_start_option() throws Throwable {
				new StepUpPage(driver).verify_photo_ID_document_details_has_clickbale_start_button();
			}

			//User selecting UK Passport option
			
			@When("^user selects the UK passport option$")
			public void user_selects_the_UK_passport_option() throws Throwable {
				driver.get(Constant.url_photoIDDocumentPage);
				Thread.sleep(1000);
				// new PhotoIDPage(driver).uk_passport_radio_button_selection();
				Thread.sleep(1000);
			    
			}

			@When("^click on continue button$")
			public void click_on_continue_button() throws Throwable {
				new PhotoIDPage(driver).user_clicks_continue_button();
				Thread.sleep(1000);
			    
			}

			@Then("^display the Take a photo of your passport page$")
			public void display_the_Take_a_photo_of_your_passport_page() throws Throwable {
				new IDInstructionsPage(driver).display_passport_intructions_page();		   
			}
			
			//user selecting driving licence option
			
			@When("^user selects the UK driving licence option$")
			public void user_selects_the_UK_driving_licence_option() throws Throwable {
				driver.get(Constant.url_photoIDDocumentPage);
				Thread.sleep(1000);
				// new PhotoIDPage(driver).uk_driving_licence_radio_button_selection();
				Thread.sleep(1000);
			    
			}

			@Then("^display the Take a photo of your driving licence page$")
			public void display_the_Take_a_photo_of_your_driving_licence_page() throws Throwable {
				new IDInstructionsPage(driver).display_drivinglicence_intructions_page();
			}
			
			//Navigating back to the What type of photo ID do you have page from Take a photo page
			@Given("^the user is on the Take a photo page$")
			public void the_user_is_on_the_Take_a_photo_page() throws Throwable {
				driver.get(Constant.url_photoIDDocumentPage);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(1000);
				// new PhotoIDPage(driver).uk_driving_licence_radio_button_selection();
				Thread.sleep(3000);
				new PhotoIDPage(driver).user_clicks_continue_button();
				Thread.sleep(1000);
				new IDInstructionsPage(driver).goBack_Link();
				Thread.sleep(1000);
				//new PhotoIDPage(driver).verify_photo_id_document_page();
			        
			}

			@Then("^display the What type of photo ID do you have page$")
			public void display_the_What_type_of_photo_ID_do_you_have_page() throws Throwable {
				driver.get(Constant.url_photoIDDocumentPage);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(1000);
				// new PhotoIDPage(driver).uk_driving_licence_radio_button_selection();
				Thread.sleep(3000);
				new PhotoIDPage(driver).user_clicks_continue_button();
				Thread.sleep(1000);
				new IDInstructionsPage(driver).goBack_Link();
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				new PhotoIDPage(driver).verify_photo_id_document_page();
				
			   }


			@When("^user selects the Neither of these option$")
			public void user_selects_the_Neither_of_these_option() throws Throwable {
				driver.get(Constant.url_photoIDDocumentPage);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(1000);
				// new PhotoIDPage(driver).neither_of_these_radio_button_selection();
				Thread.sleep(3000);
				new PhotoIDPage(driver).user_clicks_continue_button();
				Thread.sleep(1000);
				new SorryCannotContinuePage(driver).display_sorry_you_cannot_continue_page();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

			@Then("^What type of photo ID do you have Page is displayed$")
			public void what_type_of_photo_ID_do_you_have_Page_is_displayed() throws Throwable {
				driver.get(Constant.url_photoIDDocumentPage);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(1000);
				// new PhotoIDPage(driver).neither_of_these_radio_button_selection();
				Thread.sleep(3000);
				new PhotoIDPage(driver).user_clicks_continue_button();
				Thread.sleep(1000);
				new SorryCannotContinuePage(driver).display_sorry_you_cannot_continue_page();
				Thread.sleep(1000);
				new SorryCannotContinuePage(driver).verify_go_back_link();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(1000);
				new PhotoIDPage(driver).verify_photo_id_document_page();
				Thread.sleep(1000);
			    
			}

			//Select option to take a Video Selfie
			@Given("^the step up page has clickable start button on forth step Capture Video Selfie$")
			public void the_step_up_page_has_clickable_start_button_on_forth_step_Capture_Video_Selfie() throws Throwable {
				new StepUpPage(driver).verify_submit_video_selfie_has_clicakble_start_button();
				Thread.sleep(1000);
				}

			@When("^user clicks on the start button$")
			public void user_clicks_on_the_start_button() throws Throwable {
				new StepUpPage(driver).video_selfie_start_button();
				Thread.sleep(1000);
			}

			@Then("^the upload a selfie page is displayed$")
			public void the_upload_a_selfie_page_is_displayed() throws Throwable {
				
			    new VideoSelfiePage(driver).verify_take_a_video_selfie_page();
			}

			//Back to the step up page from upload a selfie page
			@Given("^the user in on the Take a selfie page$")
			public void the_user_in_on_the_Take_a_selfie_page() throws Throwable {
				new StepUpPage(driver).video_selfie_start_button();
				Thread.sleep(1000);
			}

			@When("^the user clicks the go back link$")
			public void the_user_clicks_the_go_back_link() throws Throwable {
				new VideoSelfiePage(driver).verify_take_a_video_selfie_page();
				Thread.sleep(1000);
				new VideoSelfiePage(driver).video_selfie_page_goBack_link();
			}

			@Then("^display the step up page with Video Selfie option has a start button next to it$")
			public void display_the_step_up_page_with_Video_Selfie_option_has_a_start_button_next_to_it() throws Throwable {
				new StepUpPage(driver).display_video_selfie_page();
				
			}
			
			//Capture video selfie page
//			
//			@Given("^the user is on the Take a video selfie page$")
//			public void the_user_is_on_the_Take_a_video_selfie_page() throws Throwable {
////			    driver.get(Constant.url_videoSelfiePage);
//			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			    		    
//			}
//
//			@When("^the user clicks on the Open camera button$")
//			public void the_user_clicks_on_the_Open_camera_button() throws Throwable {
//				new VideoSelfiePage(driver).click_open_camera_button();
//				Thread.sleep(1000);
//			   
//			}

			@Then("^display the capture selfie page$")
			public void display_the_capture_selfie_page() throws Throwable {
			   
			}

			@Given("^the user is on the Capture selfie page$")
			public void the_user_is_on_the_Capture_selfie_page() throws Throwable {
			   
			}

			@When("^the user clicks the Cancel link$")
			public void the_user_clicks_the_Cancel_link() throws Throwable {
			   
			}

			@Then("^display the Take a video selfie page$")
			public void display_the_Take_a_video_selfie_page() throws Throwable {
			    
			}

			
   
}

	
	




