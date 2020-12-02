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
		driver.get("https://gall.dcinside.com/board/lists/?id=tree");
		
		
		//원하는 엘리먼트들 가져오기
		//엘리먼트들의 계보를 확인해서 css선택자 방식으로 원하는 엘리먼트 지정
		List<WebElement> elements = driver.findElements(By.cssSelector(".gall_list .us-post"));
		

		//로딩 시간 부여
		//설정된 millis초 단위 만큼 쉬는 것
		Util.sleep(1000);
		
		System.out.println("== 디시인사이드 식물갤 게시물 최신글 리스트 ==");
		System.out.println("번호 / 제목 / 작성자 / 작성일 / 조회수 / 추천수");
		
		
		for(WebElement element : elements) {
			String num = element.findElements(By.cssSelector(".gall_num")).get(0).getText().trim();
			String title = element.findElements(By.cssSelector(".gall_tit")).get(0).getText().trim();
			String name = element.findElements(By.cssSelector(".nickname")).get(0).getText().trim();
			String date = element.findElements(By.cssSelector(".gall_date")).get(0).getText().trim();
			String count = element.findElements(By.cssSelector(".gall_count")).get(0).getText().trim();
			String recommend = element.findElements(By.cssSelector(".gall_recommend")).get(0).getText().trim();
			
			DCarticle article = new DCarticle(num, title, name, date, count, recommend);
			System.out.printf("%s / %s / %s / %s / %s / %s \n",article.getNum(), article.getTitle(), article.getName(), article.getDate(), article.getCount(), article.getRecommend());
		}

		
		
	}

}