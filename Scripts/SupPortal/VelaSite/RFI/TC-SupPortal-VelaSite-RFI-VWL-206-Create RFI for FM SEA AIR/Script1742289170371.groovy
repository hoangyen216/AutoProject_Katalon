import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('SupPortal/VelaSite/TC-SupPortal-VelaSite-VWL-206-Sign in'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('CreateRFI_btnCreateRFI'), 60)

WebUI.click(findTestObject('CreateRFI_btnCreateRFI'))

WebUI.click(findTestObject('CreateRFI/PopupCreateRFI/CreateRFI_PopupCreateRFI_rdoScopeOfServiceFM', [('ScopeOfService') : ScopeOfService]))

WebUI.click(findTestObject('CreateRFI/PopupCreateRFI/CreateRFI_PopupCreateRFI_btnNext'))

WebUI.click(findTestObject('CreateRFI/General Infor/CreateRFI_GeneralInfor_btnNext'))

if (ModeOfTransport == 'Air') {
    WebUI.click(findTestObject('Object Repository/CreateRFI/ServiceInfo/CapacityAndServices/btnAir'))

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/btn_AddRoutingGroup'))
} else {
    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/btn_AddRoutingGroup'))

    WebUI.waitForElementVisible(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/ddlModeOfTransport'), 60)

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/ddlModeOfTransport'))

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/itm_ModeOfTransport', [('ModeOfTransport') : ModeOfTransport]))
}

WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/rdo_ServiceType', [('ServiceType') : ServiceType]))

WebUI.delay(2)

WebUI.scrollToPosition(16, 433)

def rdoServiceType = findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/rdo_ServiceType', [('ServiceType') : 'Export'])

def classValue_rdoServiceType = WebUI.getAttribute(rdoServiceType, 'class', FailureHandling.OPTIONAL)

println('Giá trị classValue: ' + classValue_rdoServiceType)

if ((classValue_rdoServiceType != null) && classValue_rdoServiceType.contains('checked')) {
    // Nếu "Export" được chọn, thực hiện hành động tương ứng
    println('Export radio button is selected.')

    WebUI.verifyElementText(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_itemCountryVietNamdefault'), 
        'Viet Nam')

    //    WebUI.scrollToElement(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_ddlCodeSeaPortState'), 
    //        10)
    //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_ddl_CodeSea'))
    //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_itm_CodeSea', [('OriginProvince') : OriginProvince]))
    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Destination_ddl_Country'))

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Destination_itm_Country', [('DestinationCountry') : DestinationCountry //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Destination_ddl_CodeSea'))
            ] //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Destination_itm_CodeSea', [('DestinationProvince') : DestinationProvince]))
            ) // WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/btnMap Routing'))
        ) //    WebElement element = WebUI.findWebElement(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/btn_Map Routing'))
    //
    //    if (element != null) {
    //        WebUI.executeJavaScript('arguments[0].click();', Arrays.asList(element))
    //    } else {
    //        println('Element not found.')
    //    }
    //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_ddl_CodeSea'))
    //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_itm_CodeSea', [('OriginProvince') : OriginProvince]))
    //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Destination_ddl_CodeSea'))
    //WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Destination_itm_CodeSea', [('DestinationProvince') : DestinationProvince]))
} else {
    println('Export radio button is not selected.')

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_ddlCountry'))

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/Origin_itm_Country', [('OriginCountry') : OriginCountry]))
}

if (ModeOfTransport == 'Sea FCL') {
    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/ddl_Container Type'))

    WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/itm_ContainerType', [('containerType') : containerType]))
}

//    // Lấy Test Data
//    TestData datageneralVolume = TestDataFactory.findTestData('dbCreateRFI')
//
//    // Lấy giá trị từ cột "GeneralVolume" của hàng đầu tiên (index 1)
//    String generalVolume = datageneralVolume.getValue(1, 10) // Hàng 1, cột 1
WebUI.setText(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/txt_GeneralVolume'), generalVolume)

WebUI.setText(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/txtAvailableVolume'), availableVolume)

WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/CommoditySpecification_chkCommoditySpecification', 
        [('commoditySpecification') : commoditySpecification]))

WebUI.click(findTestObject('CreateRFI/ServiceInfo/CapacityAndServices/btn_Next'))

WebUI.setText(findTestObject('CreateRFI/ServiceInfo/AdditionalInfo/CreateRFI_ServiceInfo_AdditionalInfo_txtPercentage SeaFCL', 
        [('ModeOfTransport') : ModeOfTransport]), '100')

WebUI.click(findTestObject('CreateRFI/ServiceInfo/AdditionalInfo/CreateRFI_ServiceInfo_AdditionalInfo_btnNext'))

WebUI.click(findTestObject('CreateRFI/ReviewAndSubmit_btnSubmit'))

WebUI.click(findTestObject('CreateRFI/PopUp_OpexInCharge_btnSkipAndSubmit'))

WebUI.click(findTestObject('CreateRFI/PopUp_Successfull_btnOK'))

