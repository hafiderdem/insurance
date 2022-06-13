package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.sukgu.Shadow;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.Driver;
import utilities.browserUtils;
import utilities.conReader;


public class stepDefinition {

    _01_selectPrecondition selectPrecondition;
    _02_selectRegisterOwner selectRegisterOwner;
    _03_selectVehicle selectVehicle;
    _05_enterBirthDate enterBirthDate;
    _06_enterRegistrationDate registrationDate;
    _07_selectModel selectModel;
    _08_selectBodyType selectBodyType;
    _09_selectFuelTYpe selectFuelTYpe;
    _10_selectEnginePower selectEnginePower;
    _11_selectEngine selectEngine;
    _12_firstRegAndRegDate firstRegAndRegDate;

    @Given("launching browser and going to webpage")
    public void launching_browser_and_going_to_webpage() {
        Driver.getDriver().get(conReader.getProperty("url"));
        Shadow shadow= new Shadow(Driver.getDriver());
        browserUtils.waitFor(6);
        // accept cookies
        WebElement element = shadow.findElementByXPath("//button[@data-testid='uc-accept-all-button']");
        element.click();
    }


    @Then("Verify preCondition page")
    public void verify_pre_condition_page() {

        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("preConditionPage"));


    }
    @When("User setup pre conditions {string} and  insurance starting day {string}")
    public void user_setup_pre_conditions_and_insurance_starting_day(String preCondition, String inceptionDate) {

        selectPrecondition=new _01_selectPrecondition();
        selectPrecondition.setPreCondition(preCondition);
         selectPrecondition.setInceptionDate(inceptionDate);
    }

    @Then("Verify Register Owner Page")
    public void verify_register_owner_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("registeredOwnerPage"));
    }
    @When("User setup car owner {string} and new or used {string}")
    public void user_setup_car_owner_and_new_or_used(String carOwner, String condition) {
        selectRegisterOwner= new _02_selectRegisterOwner();
        selectRegisterOwner.setCarOwner(carOwner);
        selectRegisterOwner.theCarIs(condition);
        browserUtils.waitFor(1);
    }
    @Then("Verify select vehicle page")
    public void verify_select_vehicle_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("selectVehicle"));
        browserUtils.waitFor(1);
    }
    @When("User set first registration date {string} and hsn {string}  then tsn {string}")
    public void user_set_first_registration_date_and_hsn_then_tsn(String registration, String hsn, String tsn) {
        selectVehicle= new _03_selectVehicle();
        selectVehicle.setVehicle(registration,hsn,tsn);
    }
    @Then("Verify show HsnTsnCar page")
    public void verify_show_hsn_tsn_car_page() {
        browserUtils.waitFor(2);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("showHsnTsnCar"));
    }
    @Then("click continue button")
    public void click_continue_button() throws InterruptedException {
        selectPrecondition.clickContinue();
        browserUtils.waitForPageLoad(20);

    }
    @Then("Verify enterRegistrationDate page")
    public void verify_enter_registration_date_page() {
        browserUtils.waitFor(2);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("enterRegistrationDatePage"));
    }

    @When("User set registration date {string}")
    public void user_set_registration_date(String date) {
        registrationDate= new _06_enterRegistrationDate();
        registrationDate.setRegisteredDate(date);
    }
    @Then("Verify enterBirthDate page")
    public void verify_enter_birth_date_page() {
        browserUtils.waitFor(2);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("enterBirthDatePage"));
    }
    @When("User enter BD {string}")
    public void user_enter_bd(String BD) {
        enterBirthDate= new _05_enterBirthDate();
        enterBirthDate.setBirthdate(BD);
    }


    // manual way step definition methods


    @When("User choose make {string}")
    public void user_choose_make(String brand) {
        selectVehicle= new _03_selectVehicle();
        selectVehicle.findByMakeAndModel();
        selectVehicle.selectManufacturer(brand);
    }

    @Then("Verify select model page")
    public void verify_select_model_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("selectModelPage"));

    }

    @When("User choose model {string}")
    public void user_choose_model(String model) {
        selectModel= new _07_selectModel();
        selectModel.selectModel(model);

    }

    @Then("Verify select body type page")
    public void verify_select_body_type_page() {
        browserUtils.waitFor(1);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("selectBodyTypePage"));

    }

    @When("User select body type {string}")
    public void user_select_body_type(String string) {
        selectBodyType=new _08_selectBodyType();
        browserUtils.waitFor(1);
        selectBodyType.selectBodyType(string);

    }

    @Then("Verify fuel type page")
    public void verify_fuel_type_page() {
        browserUtils.waitFor(1);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("selectFuelTypePage"));
    }

    @When("User select fuel type {string}")
    public void user_select_fuel_type(String fuelType) {
        selectFuelTYpe= new _09_selectFuelTYpe();
        selectFuelTYpe.selectFuelType(fuelType);
    }

    @Then("Verify select engine power page")
    public void verify_select_engine_power_page() throws InterruptedException {
        browserUtils.waitFor(2);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("selectEnginePowerPage"));
    }

    @When("User select engine power {string}")
    public void user_select_engine_power(String enginePower) {
        selectEnginePower= new _10_selectEnginePower();
        selectEnginePower.selectEnginePower(enginePower);
    }

    @Then("Verify select engine page")
    public void verify_select_engine_page() throws InterruptedException {
        browserUtils.waitFor(1);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),conReader.getProperty("selectEnginePage"));
    }

    @When("User select engine {string}")
    public void user_select_engine(String engine) {
        selectEngine= new _11_selectEngine();
        selectEngine.selectEngine(engine);
//        selectEngine.select();
    }

    @When("User set first registration date {string} and {string}")
    public void user_set_first_registration_date_and(String string,String string2) {
        firstRegAndRegDate= new _12_firstRegAndRegDate();

        firstRegAndRegDate.setRegistrationDate(string,string2);

    }


}
