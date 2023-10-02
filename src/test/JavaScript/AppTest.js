const { Builder, By, Key, until } = require('selenium-webdriver'); // Hämtar från node_modules

async function test() {
    let driver;

        // Skapa en instans av Selenium WebDriver med din önskade webbläsare (t.ex. Chrome)
    driver = await new Builder().forBrowser('chrome').build();

        // Navigerar till sidan
    await driver.get('http://localhost:8080/index.html');

        // Skapar upp en task "diska" i textfält, tid och datum
    await driver.findElement(By.id("taskText")).sendKeys("Diska", Key.RETURN)

    const taskDate = await driver.findElement(By.id("taskDate"));
    await taskDate.sendKeys("2023-10-02");

    const dateInput = await driver.findElement(By.id("taskTime"));
    await dateInput.sendKeys("12:00");


        // Adderar tasken
    const pushBtn = await driver.wait(until.elementIsEnabled(driver.findElement(By.id('push'))));
    await pushBtn.click();




    //await driver.quit();
};

test();













/*// START - Öppnar och kollar att browsern + url fungerar
async function test() {
    let driver = await new Builder().forBrowser("chrome").build();

    await driver.get("http://localhost:63342/workflow-dockerimage-actions/workflow-dockerimage-actions.main/static/index.html?_ijt=la517v15pcp4fc5fsvtpv4bof");
    //await driver.findElement(By.name("q")).sendKeys("Selenium", Key.RETURN)
}
test();*/