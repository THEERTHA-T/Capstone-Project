package com.capstone.testing;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginServiceTest {
	WebDriver driver;

	@BeforeTest
	public void config() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterClass() {
		driver.close();
	}

	@Test(priority = 1)
	public void homeTest() throws InterruptedException {
		driver.get("http://localhost:4200/");
		System.out.println("navigated to home page");

//	// Assuming you have already initialized and navigated to the webpage
		WebElement loginBtn = driver.findElement(By.name("LOGIN"));
		loginBtn.click();
		System.out.println("navigated to Login page");

	}

	@Test(priority = 2)
	public void registerTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("http://localhost:4200/signup");

		WebElement emailTF = driver.findElement(By.name("emailid"));
		emailTF.sendKeys("user2@gmail.com");

		WebElement passwordTF = driver.findElement(By.name("password"));
		passwordTF.sendKeys("9876543210");

		WebElement userRadioButton = driver.findElement(By.name("user"));
		userRadioButton.click();
		Thread.sleep(5000);
		WebElement registerbtn = driver.findElement(By.name("REGISTER"));
		registerbtn.click();

		System.out.println("registered success");

	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		driver.get("http://localhost:4200/login");

		Thread.sleep(5000);
		WebElement emailTF = driver.findElement(By.name("emailid"));
		emailTF.sendKeys("user2@gmail.com");

		WebElement passwordTF = driver.findElement(By.name("password"));
		passwordTF.sendKeys("9876543210");

		WebElement userRadioButton = driver.findElement(By.name("user"));
		userRadioButton.click();
		Thread.sleep(5000);

		WebElement loginbtn = driver.findElement(By.name("LOGIN"));
		loginbtn.click();

		System.out.println("login success");

	}

	@Test(priority = 4)
	public void applyAadharTest() throws InterruptedException {
		driver.get("http://localhost:4200/userHome");
		// Assuming you have already initialized and navigated to the webpage
		WebElement apply = driver.findElement(By.linkText("Apply For New Aadhar Card")); // Replace "Link Text" with the
																							// actual text of the link
																							// you want to click
		apply.click();
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Myuser");
		WebElement email = driver.findElement(By.id("emailid"));
		email.sendKeys("Myuser@gmail.com");
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Web Hills Parlour");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9870654321");
		Thread.sleep(8000);

		WebElement applybtn = driver.findElement(By.name("apply"));
		applybtn.click();
		Thread.sleep(2000);

		System.out.println("Aadhar applied succes");

	}

	@Test(priority = 5)
	public void approveRequestTest() throws InterruptedException {
		driver.get("http://localhost:4200/adminHome");
		WebElement view = driver.findElement(By.linkText("View Requests")); // Replace "Link Text" with the actual text
																			// of the link you want to click
		view.click();
		Thread.sleep(2000);
		System.out.println("Approval Navigation success");

		driver.get("http://localhost:4200/adminHome/viewReq");

		WebElement applybtn = driver.findElement(By.name("approve"));
		applybtn.click();
		System.out.println("Approval success");


	}

	@Test(priority = 6)
	public void viewAllRequestTest() {
		driver.get("http://localhost:4200/adminHome/viewall");
		System.out.println("View All Request succes");

	}

	@Test(priority = 7)
	public void AadharUpdateTest() {
		driver.get("http://localhost:4200/updateaadhar");
		System.out.println("Aadhar Updation succes");

	}

	@Test(priority = 8)
	public void viewMyAdharTest() {
		driver.get("http://localhost:4200/viewmyadhar");
		System.out.println("View succes");

	}

	@Test(priority = 9)
	public void logoutTest() {
		driver.get("http://localhost:4200/adminHome/viewall");
		System.out.println("Logout succes");

	}

	@Test(priority = 9)
	public void requestDuplicateTest() throws InterruptedException {
		driver.get("http://localhost:4200/userHome");

		WebElement app = driver.findElement(By.name("duplicate"));
		app.click();
		Thread.sleep(5000);

		System.out.println("Request Duplicate Success");

	}

	@Test(priority = 10)
	public void closeAadharTest() throws InterruptedException {
		driver.get("http://localhost:4200/userHome");

		WebElement app = driver.findElement(By.name("close"));
		app.click();
		Thread.sleep(5000);

		System.out.println("Close Aadhar Success");

	}

}
