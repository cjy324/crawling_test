package crawling_test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import crawling_test.dto.DCarticle;
import crawling_test.dto.naverNews;

public class Main {

	public static void main(String[] args) {
		//운영체제 수준에서의 변수를 가져온다	
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");
	//System.getProperty("user.dir")
	//시스템 변수
	//운영체제 수준에서의 변수를 가져온다
	//user.dir = "C:\work\sts-4.8.0.RELEASE-workspace\java-selenium-exam"

		//WebDriver 경로 설정
		System.setProperty("webdriver.chrome.driver", path.toString());
		//운영체제 수준에서 변수를 굽는다???
		
		//WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");  //전체화면으로 실행
		options.addArguments("disable-popup-blocking");  //팝업 무시
		options.addArguments("disable-defult-apps");  //기본앱 사용 안함 ex)인터넷익스플로러, 엣지 등 기본앱 사용 x

		//WebDriver 객체 생성
		ChromeDriver driver = new ChromeDriver(options);   //설정된 옵션 값 주입
		
		/*
		 * //빈 탭 생성 driver.executeScript("window.open('about:blank','_blank');");
		 */		
		//열린 탭 리스트 가져오기
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());

		/*
		 * //첫번째 탭으로 전환 driver.switchTo().window(tabs.get(0));
		 */
		
		//원하는 사이트 주소 입력
		driver.get("https://news.daum.net/society#1");
		
		
		//원하는 엘리먼트들 가져오기
		//엘리먼트들의 계보를 확인해서 css선택자 방식으로 원하는 엘리먼트 지정
		List<WebElement> elements = driver.findElements(By.cssSelector(".list_timenews li"));
		

		//로딩 시간 부여
		//설정된 millis초 단위 만큼 쉬는 것
		Util.sleep(1000);
		
		System.out.println("== 다음 주요 뉴스 리스트 ==");
		
		for(WebElement element : elements) {
			String id = element.findElement(By.cssSelector("strong > a")).getAttribute("data-tiara-id");
			String date = element.findElement(By.cssSelector("strong > a")).getAttribute("data-tiara-id");
			String time = element.findElement(By.cssSelector(".txt_time")).getText().trim();
			String title = element.findElement(By.cssSelector("strong > a")).getText().trim();

			/*
			 * naverNews naverNews = new naverNews(title, body, news, imgURL);
			 */
			System.out.printf("번호 : %s\n",id);
			System.out.printf("날짜 : %s\n",date);
			System.out.printf("날짜 : %s\n",time);
			System.out.printf("제목 : %s\n",title);
			
		}

		
		
	}

}
