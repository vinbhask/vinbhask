package library;

public class Object_Definition_Library {

	public static String getEnvVar(String tag) {
		String tag_Value = Retrieve_EnvVar.ReportGlobalParameters(tag);
		//System.out.println("Tag Value ="+tag_Value);
		return tag_Value;
	}


	public String url="http://bi4/BOE/portal/1410180356/InfoView/logon.faces";
	public String urlstg="http://bo-stg-02:8080/BOE/portal/1410180356/InfoView/logon.faces";
	public String logon_userName="//*[@id='_id0:logon:USERNAME']";
	public String logon_passWord="//*[@id='_id0:logon:PASSWORD']";
	public String credentials_prod="C:\\Users\\vinod\\Desktop\\SAP_BO_Credentials.txt";
	public String logon_dropDown="//*[@id='_id0:logon:AUTH_TYPE']";
	public String logon_dropDownOpt="Enterprise";
	public String logon_click="//*[@id='_id0:logon:logonButton']";
	public String documents="//*[@id='id_8']/div[3]/a";
	public String AutoPocFoldProd="//*[@id='MyDocs_treeView_treeNode3_name']";
	public String AutoPocFileProd="/html/body/form/div[2]/div[1]/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[2]/div";
	public String AutoPocFoldStg=".//*[@id='MyDocs_treeView_treeNode4_name']";
	public String AutoPocFileStg="/html/body/form/div[2]/div[1]/div[2]/div[3]/div/div[2]/table/tbody/tr/td[2]/div";
	public String BOUISystemNameXpath=".//*[@id='_id0:logon:CMS']";

	public String GotoLastPage=".//*[@id='IconImg_ListingURE_goLastButton']";

	public String frame1="/html/body/div[7]/div/div/div[1]/div/div/iframe";
	public String folder_select="//*[@id='MyDocs_treeView_treeNode3_name']";
	public String file_select="html/body/form/div[2]/div[1]/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[2]/div";
	public String file_select2="/html/body/form/div[2]/div[1]/div[2]/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div";
	public String AutoPocFile2Stg="/html/body/form/div[2]/div[1]/div[2]/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div";
	public String file_opt_select="Modify";
	public String frame2="/html/body/div[3]/div/div/div/div/div/iframe";
    public String webIntellimgstg=".//*[@id='id_46']/img";
	public String webIntellimg=".//*[@id='id_51']/img";
	public String universe_select=".//*[@id='mlst_bodyunvList']/div/table/tbody/tr[1]/td[1]/div";
	public String ExcelPath_1="C:\\Users\\vinod\\Desktop\\BO_Reports\\Automation_POC.xls";
	public String ExcelPath_2="C:\\Users\\vinod\\Desktop\\BO_Reports\\Automation_POC-Prod.xls";
	//public String ExcelPath_1="C:\\Users\\vinod\\Desktop\\BO_Reports\\Actors-1.xls";
	//public String ExcelPath_2="C:\\Users\\vinod\\Desktop\\BO_Reports\\Actors-2.xls";
	public String Results_folder="C:\\Users\\vinod\\Desktop\\BO_Reports";
	public String Primaryfolder="//*[@id='MyDocs_treeView_treeNode6_name']";
	public String Secondaryfolder="//*[@id='MyDocs_treeView_treeNode21_name']";
	public String BackToDocuments=".//*[@id='id_8']/div[3]/a";
	public String TC_001__REVENUE=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";

	public String Folders = "//*[@id='yui-gen0-2-label']";
	public String PublicFolders = ".//*[@id='accordionNavigationView_drawer1_treeView_treeNode1_name']";

	/* SI and AE Xpaths */
	public String StartSIButton="html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td/input[2]";
	public String RequestMenu="html/body/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]/a";
	public String CompanyOptions="html/body/table/tbody/tr[1]/td[1]/table/tbody/tr[2]/td[2]/a";
	public String Theater_Dropdown="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[9]/td[1]/select";
	public String Theater_dropDownOpt="EMEA";
	public String CompanyValue="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[10]/td[1]/input";
	public String CompanyName="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[10]/td[3]/input";
	public String FunctionalCurrency="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[11]/td[1]/select";
	public String FunctionalCurrencyValue="AUD, Australian Dollar";
	public String TextArea="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[11]/td[3]/textarea";
	public String Text="Sample dummy text as part of SI automation POC";
	public String RequestorCommentBox="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[14]/td[1]/textarea";
	public String RequestorComment="Dummy request";
	public String SISubmitButton="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[16]/td/input[1]";
	public String ConfirmButton="html/body/table/tbody/tr[2]/td/form/table/tbody/tr[15]/td/input[1]";

	public String ManualUpload=".//*[@id='bodyContent']/div[2]/form/div[3]/div[1]/a";
	public String BrowseButton=".//*[@id='bodyContent']/div[2]/form/div/table/tbody/tr[1]/td[1]/input";
	public String DollarFilePath="C:\\Users\\vinod\\Documents\\Dollar_Upload_Template.xls";
	public String UploadButton=".//*[@id='bodyContent']/div[2]/form/div/table/tbody/tr[3]/td/input[2]";
	public String SubMeasureLink=".//*[@id='bodyContent']/div[2]/form/div[3]/div[2]/a";
	public String MeasureNameDropDown=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr/td[2]/select";
	public String MeasureNameValue="Indirect Revenue Adjustments";
	public String MeasureNameAdd=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[4]/td/input[2]";
	public String Source=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]/select";
	public String SourceValue="Manual Upload";
	public String SubMeasureName=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[5]/td[2]/input[1]";
	public String SubMeasureNameValue="Test";
	public String Hierarchy=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[9]/td[2]/table/tbody/tr[3]/td[1]/input[1]";
	public String HierarchyLevel=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[9]/td[2]/table/tbody/tr[3]/td[3]/select";
	public String HierarchyOption="BE";
	public String DescriptionTextBox=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[11]/td[2]/textarea";
	public String DescriptionText="Test";
	public String EffectiveMonth=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[13]/td[2]/select";
	public String EffectiveMonthValue="APR FY2015";
	public String FrequencyTiming=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[15]/td[2]/select";
	public String FrequencyTimingValue="MONTHLY";
	public String DataRoute=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[17]/td[2]/textarea";
	public String DataRouteText="Excel";
	public String DiscountFlag=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[18]/td[2]/select";
	public String DiscountFlagvalue="NO";
	public String PNLNODE=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[1]/td/table/tbody/tr[19]/td[2]/select";
	public String PNLNODEValue="INDIRECT REVENUE ADJUSMENTS";
	public String NextButton=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[2]/td/input[3]";
	public String AEConfirmButton=".//*[@id='bodyContent']/div[2]/form/table/tbody/tr[2]/td/p/input[3]";
	public String UTAutomation=".//*[@id='utAutomationNode']";

	public String CFAUsername="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[2]/div[2]/div[3]/div[2]/form/div[1]/div[1]/div/div[1]/div[1]/input";
	public String CFAPassword="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[2]/div[2]/div[3]/div[2]/form/div[1]/div[1]/div/div[1]/div[2]/input";
	public String CFALogingSubmitButton="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[2]/div[2]/div[3]/div[2]/form/div[3]/input";
	public String FinancialAnalyser="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr/td[1]/div/table/tbody/tr/td[2]/a";
	public String SharedReports="/html/body/div/div[2]/div/div[2]/div/div/div[2]/div[3]/div/div/div/div/div[12]/div[1]/div[1]/div";
	public String EndUsersFolder="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[2]/a";
	public String PowerUsersFolders=".//*[@id='FolderIcons']/tbody/tr[3]/td[2]/div/table/tbody/tr/td[2]/a";
	public String FinITFolder="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/div/table/tbody/tr/td[2]/a";
	public String QAFolder="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/a";
	public String QAFinancial="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[1]/div/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/a";
	public String DocumentsFolder="/html/body/div[2]/table/tbody/tr/td[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/div/table/tbody/tr/td[2]/a";
	public String CFAProductRevenueReport=".//*[@id='FolderIcons']/tbody/tr[6]/td[2]/div/table/tbody/tr/td[2]/a";
	public String DesignModeButton=".//*[@id='tbDesignMode']";
	public String RunReportButton=".//*[@id='tbRunReport']";
	public String CFABackArrow=".//*[@id='tbBack0']";
	public String CFAProductRevenueCube=".//*[@id='FolderIcons']/tbody/tr[16]/td[1]/div/table/tbody/tr/td[2]/a";
	public String CFA_file_option_select=".//*[@id='cm1r0']/td[3]";
	public String CFA_file_opt_select="Republish";
	public String CFA_Results_File_Upload="C:\\Users\\vinod\\Desktop\\Product Bookings\\Product Bookings\\Results\\Report_ProductRevenue_SFH.xls";
	public String CFAFileUploadOkButton="C:\\CFAFileUploadOkButton";


	/*BO Compatibility Xpaths */
			/*Bookings Reporting*/
			public String TC001_A__BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B__BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC001_C__BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC002_A_TOTAL__BOOKINGS_NET =".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC003_A_PRODUCT_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC003_B_PRODUCT_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC003_C_PRODUCT_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC004_A_TOTAL__PRODUCT_BOOKINGS_NET =".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC004_B_TOTAL__PRODUCT_BOOKINGS_NET =".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC005_A_SERVICE_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC005_B_SERVICE_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC005_C_SERVICE_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC006_A_UPLIFT_BOOKINGS =".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC007_A_ACQUISITION =".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC008_A_ACQUISITION_NON_ =".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC009_A_NOT_BOOKED_MEASURES =".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC009_B_NOT_BOOKED_MEASURES =".//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC010_A_NOT_BOOKED_MEASURES_HISTORY =".//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC010_B_NOT_BOOKED_MEASURES_HISTORY =".//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC011_A_CONDITIONAL_SALES=".//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC011_B_CONDITIONAL_SALES=".//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC012_A_CONDITIONAL_SALES_HISTORY=".//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC013_A_SHIPMENTS =".//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC013_B_SHIPMENTS =".//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC014_A_SHIPPED_NOT_INVOICED =".//*[@id='ListingURE_detailView_listColumn_24_0_1']";
			public String TC014_B_SHIPPED_NOT_INVOICED =".//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC015_A_FINANCE_BACKLOG =".//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC015_B_FINANCE_BACKLOG =".//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC016_A_FINANCE_BACKLOG_HISTORY =".//*[@id='ListingURE_detailView_listColumn_28_0_1']";
			public String TC016_B_FINANCE_BACKLOG_HISTORY =".//*[@id='ListingURE_detailView_listColumn_29_0_1']";
			public String TC017_A_MANUFACTURING_BACKLOG =".//*[@id='ListingURE_detailView_listColumn_30_0_1']";
			public String TC017_B_MANUFACTURING_BACKLOG =".//*[@id='ListingURE_detailView_listColumn_31_0_1']";
			public String TC018_A_MANUFACTURING_BACKLOG_HISTORY =".//*[@id='ListingURE_detailView_listColumn_32_0_1']";
			public String TC018_B_MANUFACTURING_BACKLOG_HISTORY =".//*[@id='ListingURE_detailView_listColumn_33_0_1']";
			public String TC019_A_DEBOOKINGS =".//*[@id='ListingURE_detailView_listColumn_34_0_1']";
			public String TC019_B_DEBOOKINGS =".//*[@id='ListingURE_detailView_listColumn_35_0_1']";
			public String TC020_A_MANAGED_SERVICES =".//*[@id='ListingURE_detailView_listColumn_36_0_1']";
			public String TC021_A_BOOKINGS_ADJUSTMENTS =".//*[@id='ListingURE_detailView_listColumn_37_0_1']";
			public String TC021_B_BOOKINGS_ADJUSTMENTS =".//*[@id='ListingURE_detailView_listColumn_38_0_1']";
			public String TC022_A_CREDIT_MEMO_RMA =".//*[@id='ListingURE_detailView_listColumn_39_0_1']";
			public String TC022_B_CREDIT_MEMO_RMA =".//*[@id='ListingURE_detailView_listColumn_40_0_1']";
			public String TC023_A_Management_Adjustments =".//*[@id='ListingURE_detailView_listColumn_41_0_1']";
			public String TC023_B_Management_Adjustments =".//*[@id='ListingURE_detailView_listColumn_42_0_1']";
			public String TC024_A_TOTAL_REBATES =".//*[@id='ListingURE_detailView_listColumn_43_0_1']";
			public String TC024_B_TOTAL_REBATES =".//*[@id='ListingURE_detailView_listColumn_44_0_1']";
			public String TC025_A_OA_BundleID_Bookings=".//*[@id='ListingURE_detailView_listColumn_45_0_1']";
			public String TC025_B_OA_BundleID_Bookings=".//*[@id='ListingURE_detailView_listColumn_46_0_1']";
			public String TC026_A_ON_SN_Bookings=".//*[@id='ListingURE_detailView_listColumn_47_0_1']";
			public String TC026_B_ON_SN_Bookings=".//*[@id='ListingURE_detailView_listColumn_48_0_1']";
			public String TC026_C_ON_SN_Bookings=".//*[@id='ListingURE_detailView_listColumn_49_0_1']";
			public String TC027_A_RTM_Bookings=".//*[@id='ListingURE_detailView_listColumn_50_0_1']";
			public String TC028_A_OA_POSReports_Bookings =".//*[@id='ListingURE_detailView_listColumn_51_0_1']";
			public String TC028_B_RTM_Bookings=".//*[@id='ListingURE_detailView_listColumn_52_0_1']";
			public String TC029_A_BGM=".//*[@id='ListingURE_detailView_listColumn_53_0_1']";
			public String TC029_B_BGM=".//*[@id='ListingURE_detailView_listColumn_54_0_1']";
			public String TC029_C_BGM=".//*[@id='ListingURE_detailView_listColumn_55_0_1']";
			public String TC030_A_Sales_Order_Notes_Number_TCH=".//*[@id='ListingURE_detailView_listColumn_56_0_1']";
			public String TC030_B_Sales_Order_Notes_Number_TCH=".//*[@id='ListingURE_detailView_listColumn_57_0_1']";
			public String TC031_A_XAAS_ATTRIBUTE=".//*[@id='ListingURE_detailView_listColumn_58_0_1']";
			public String TC032_A_GlobalVirtualSales=".//*[@id='ListingURE_detailView_listColumn_59_0_1']";
			public String TC032_B_GlobalVirtualSales=".//*[@id='ListingURE_detailView_listColumn_60_0_1']";
			public String TC032_C_GlobalVirtualSales=".//*[@id='ListingURE_detailView_listColumn_61_0_1']";
			public String TC033_A_SaaS_Attributes=".//*[@id='ListingURE_detailView_listColumn_62_0_1']";

			public String TC034_A_FCM_Bookings="//*[@id='ListingURE_detailView_listColumn_63_0_1']";
			public String TC034_B_FCM_Bookings="//*[@id='ListingURE_detailView_listColumn_64_0_1']";
			public String TC035_A_OEHieararchy_Bookings="//*[@id='ListingURE_detailView_listColumn_65_0_1']";
			public String TC035_B_OEHieararchy_ProductBookings="//*[@id='ListingURE_detailView_listColumn_66_0_1']";
			public String TC035_C_OEHieararchy_BookingsGM="//*[@id='ListingURE_detailView_listColumn_67_0_1']";
			public String TC035_D_OEHieararchy_ServiceBookings="//*[@id='ListingURE_detailView_listColumn_68_0_1']";
			public String TC035_E_OEHieararchy_BookingsAdj="//*[@id='ListingURE_detailView_listColumn_69_0_1']";
			public String TC035_F_OEHieararchy_CMRMA="//*[@id='ListingURE_detailView_listColumn_70_0_1']";
			public String TC035_G_OEHieararchy_BookingsNBM="//*[@id='ListingURE_detailView_listColumn_71_0_1']";
			public String TC035_H_OEHieararchy_CondSales="//*[@id='ListingURE_detailView_listColumn_72_0_1']";
			public String TC035_I_OEHieararchy_Shipments="//*[@id='ListingURE_detailView_listColumn_73_0_1']";
			public String TC035_J_OEHieararchy_ShippingNotInv="//*[@id='ListingURE_detailView_listColumn_74_0_1']";
			public String TC036_A_POE_Bookings="//*[@id='ListingURE_detailView_listColumn_75_0_1']";
			public String TC036_B_POE_Bookings="//*[@id='ListingURE_detailView_listColumn_76_0_1']";
			public String TC036_C_POE_Bookings="//*[@id='ListingURE_detailView_listColumn_77_0_1']";
			public String TC037_A_CSC_Bookings="//*[@id='ListingURE_detailView_listColumn_78_0_1']";
			public String TC037_B_CSC_Bookings="//*[@id='ListingURE_detailView_listColumn_79_0_1']";
			public String TC038_A_Enterprise_SKU="//*[@id='ListingURE_detailView_listColumn_80_0_1']";
			public String TC038_B_Enterprise_SKU="//*[@id='ListingURE_detailView_listColumn_81_0_1']";

			public String TC039_A_Attribution_SubSKU="//*[@id='ListingURE_detailView_listColumn_82_0_1']";
			public String TC040_A_DSV_EnableSO="//*[@id='ListingURE_detailView_listColumn_83_0_1']";
			public String TC041_A_BGM="//*[@id='ListingURE_detailView_listColumn_84_0_1']";
			public String TC042_A_POSEnrichment="//*[@id='ListingURE_detailView_listColumn_94_0_1']";
			public String TC042_B_POSEnrichment="//*[@id='ListingURE_detailView_listColumn_95_0_1']";
			public String TC043_A_New_Renewal="//*[@id='ListingURE_detailView_listColumn_87_0_1']";
			public String TC044_A_SalesMotionContext="//*[@id='ListingURE_detailView_listColumn_88_0_1']";
			public String TC045_A_SubscriptionDetails="//*[@id='ListingURE_detailView_listColumn_89_0_1']";
			public String TC045_B_SubscriptionDetails="//*[@id='ListingURE_detailView_listColumn_90_0_1']";
			public String TC046_A_MLB="//*[@id='ListingURE_detailView_listColumn_91_0_1']";
			public String TC046_B_MLB="//*[@id='ListingURE_detailView_listColumn_92_0_1']";
			public String TC046_C_MLB="//*[@id='ListingURE_detailView_listColumn_93_0_1']";

			public String TC047_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_94_0_1']";
			public String TC047_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_95_0_1']";
			public String TC048_A_Distributors=".//*[@id='ListingURE_detailView_listColumn_96_0_1']";
			public String TC048_B_Distributors=".//*[@id='ListingURE_detailView_listColumn_97_0_1']";
			public String TC048_C_Distributors=".//*[@id='ListingURE_detailView_listColumn_98_0_1']";
			public String TC049_A_SBPAttributes=".//*[@id='ListingURE_detailView_listColumn_99_0_1']";

			public String TC050_A_Offers_ELA=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC050_A_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC051_A_Restatements=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC051_B_Restatements=".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC051_C_Restatements=".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC051_D_Restatements=".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC051_E_Restatements=".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC051_F_Restatements=".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC052_A_MPOB=".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC053_TS_Backlog=".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC054_A_POSEnrchmnt=".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC055_A_TSLAttribute=".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC056_A_C1Attribute=".//*[@id='ListingURE_detailView_listColumn_13_0_1']";


			/*public String TC047_A_POSEnrichment="//*[@id='ListingURE_detailView_listColumn_94_0_1']";
			public String TC047_B_POSEnrichment="//*[@id='ListingURE_detailView_listColumn_95_0_1']";


			/*CHANNELS REPORTING*/
			public String TC001_A_Inventory =".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC002_A_POS =".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC002_B_POS =".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC003_A_NET_POS_MEASURES =".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC004_A_MS_POS_MEASURES =".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC004_B_MS_POS_MEASURES =".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC005_A_POS_WPL =".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC005_B_POS_WPL =".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC006_A_ALLOCATED_POS =".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC006_B_ALLOCATED_POS =".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC007_A_POS_WPL_GPL=".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC007_B_POS_WPLGPL=".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC008_A_CTMP_RELATED_RMA =".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC008_B_CTMP_RELATED_RMA =".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC009_A_INVALID_CLAIMS =".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC010_A_CLAIMS =".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC011_A_CLAIM_SPLITS =".//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC012_A_REBATES_GENERATED =".//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC013_OA_BunPID_ChannelsReporting=".//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC014_A_DSV_BOOKINGS=".//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC014_B_DSV_BOOKINGS=".//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC015_ON_SN_ChannelsReporting=".//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC016_A_DSVALLOCATED_BOOKINGS=".//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC016_B_DSVALLOCATED_BOOKINGS=".//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC017_DSV_BOOKINGS=".//*[@id='ListingURE_detailView_listColumn_24_0_1']";
			public String TC018_RTM_Bookings=".//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC019_DSVBacklog_Bookings_Timehirearchy=".//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC020_DSVbacklog_Bookings_productHirearchy=".//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC021_DSVBacklog_Bookings_BEhirearchy=".//*[@id='ListingURE_detailView_listColumn_28_0_1']";
			public String TC022_DSVBacklog_Bookings_Customer=".//*[@id='ListingURE_detailView_listColumn_29_0_1']";
			public String TC023_DSVBacklog_Bookings_SalesHIrearchy=".//*[@id='ListingURE_detailView_listColumn_30_0_1']";
			public String TC024_DSVBacklog_Bookings_ERPCustomer=".//*[@id='ListingURE_detailView_listColumn_31_0_1']";
			public String TC025_A_Sales_Order_Notes_Number_TCH=".//*[@id='ListingURE_detailView_listColumn_32_0_1']";
			public String TC026_A_XAAS_ATTRIBUTES=".//*[@id='ListingURE_detailView_listColumn_33_0_1']";
			public String TC027_A_SaaS_Attributes=".//*[@id='ListingURE_detailView_listColumn_34_0_1']";
			public String TC028_A_OE_Hierarchies=".//*[@id='ListingURE_detailView_listColumn_35_0_1']";
			public String TC028_B_OE_Hierarchies=".//*[@id='ListingURE_detailView_listColumn_36_0_1']";
			public String TC028_C_OE_Hierarchies=".//*[@id='ListingURE_detailView_listColumn_37_0_1']";
			public String TC028_D_OE_Hierarchies=".//*[@id='ListingURE_detailView_listColumn_38_0_1']";
			public String TC028_E_OE_Hierarchies=".//*[@id='ListingURE_detailView_listColumn_39_0_1']";
			public String TC028_F_OE_Hierarchies=".//*[@id='ListingURE_detailView_listColumn_40_0_1']";
			public String TC029_A_POE_ChannelsReporting=".//*[@id='ListingURE_detailView_listColumn_41_0_1']";
			public String TC029_B_POE_ChannelsReporting=".//*[@id='ListingURE_detailView_listColumn_42_0_1']";
			public String TC030_A_CSC_ChannelsReporting=".//*[@id='ListingURE_detailView_listColumn_43_0_1']";
			public String TC031_A_Enterprise_SKU=".//*[@id='ListingURE_detailView_listColumn_44_0_1']";

			public String TC032_A_DSVReporting_EnablePONumber=".//*[@id='ListingURE_detailView_listColumn_45_0_1']";
			public String TC033_A_AbilitytodistinguishtheAttributionSubSKU=".//*[@id='ListingURE_detailView_listColumn_46_0_1']";
			public String TC034_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_47_0_1']";
			public String TC034_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_48_0_1']";
			public String TC035_A_New_Renew=".//*[@id='ListingURE_detailView_listColumn_49_0_1']";
			public String TC035_A_New_Renew_POS=".//*[@id='ListingURE_detailView_listColumn_50_0_1']";
			public String TC036_A_SubscriptionDetails=".//*[@id='ListingURE_detailView_listColumn_51_0_1']";
			public String TC037_A_MLB=".//*[@id='ListingURE_detailView_listColumn_52_0_1']";

			public String TC038_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_53_0_1']";
			public String TC038_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_54_0_1']";
			public String TC039_A_Distributors=".//*[@id='ListingURE_detailView_listColumn_55_0_1']";
			public String TC039_B_Distributors=".//*[@id='ListingURE_detailView_listColumn_56_0_1']";
			public String TC039_C_Distributors=".//*[@id='ListingURE_detailView_listColumn_57_0_1']";
			public String TC040_A_SBPAttributes=".//*[@id='ListingURE_detailView_listColumn_58_0_1']";
			public String TC041_A_DSV=".//*[@id='ListingURE_detailView_listColumn_59_0_1']";
			public String TC041_B_DSV=".//*[@id='ListingURE_detailView_listColumn_60_0_1']";
			public String TC042_A_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_61_0_1']";
			public String TC043_A_MPOB=".//*[@id='ListingURE_detailView_listColumn_62_0_1']";
			public String TC044_A_POSEnrchmnt=".//*[@id='ListingURE_detailView_listColumn_63_0_1']";
			public String TC045_A_TSLAttribute=".//*[@id='ListingURE_detailView_listColumn_64_0_1']";
			public String TC046_A_C1Attribute=".//*[@id='ListingURE_detailView_listColumn_65_0_1']";


			/*CA Service Reporting*/
			public String TC001_A_CA_SERVICE_REPORTING=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC002_A_CA_SERVICE_ADJUSTMENTS=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC002_B_CA_SERVICE_ADJUSTMENTS=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC003_A_CA_SERVICE_NOT_BOOKED_MEASURES =".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC004_A_CA_SERVICE_NOT_BOOKED_MEASURES_HISTORY =".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC005_A_CA_SERVICE_POS =".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC006_A_CA_SERVICE_NET_POS_MEASURES =".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC007_A_CA_SERVICE_MS_POS_MEASURES =".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC008_A_CA_SERVICE_SALES_AT_POS_WPL =".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC009_A_CA_SERVICE_CONDITIONAL_SALES =".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC010_A_CA_SERVICE_CONDITIONAL_SALES_HISTORY =".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC011_A_CA_SERVICE_FINANCE_BACKLOG =".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC012_A_CA_SERVICE_FINANCE_BACKLOG_HISTORY =".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC013_A_CA_SERVICE_MANUFACTURING_BACKLOG =".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC014_A_CA_SERVICE_MANUFACTURING_BACKLOG_HISTORY =".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC015_A_CA_SERVICE_ACQUISITION_NON_=".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC016_A_CA_SERVICE_REPORTING_DEMO=".//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC016_B_CA_SERVICE_REPORTING_DEMO=".//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC017_A_CA_SERVICE_OA_BundlePID=".//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC018_A_CA_SERVICE_ON_SN=".//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC019_A_CA_SERVICE_REPORTING_DSV_Allocated=".//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC019_B_CA_SERVICE_REPORTING_DSV_Allocated=".//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC019_C_CA_SERVICE_REPORTING_DSV_Allocated=".//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC019_D_CA_SERVICE_REPORTING_DSV_Allocated=".//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC020_A_CA_SERVICE_REPORTING_DSV_Bookings=".//*[@id='ListingURE_detailView_listColumn_24_0_1']";
			public String TC020_B_CA_SERVICE_REPORTING_DSV_Bookings=".//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC020_C_CA_SERVICE_REPORTING_DSV_Bookings=".//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC020_D_CA_SERVICE_REPORTING_DSV_Bookings=".//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC021_RTM_Bookings=".//*[@id='ListingURE_detailView_listColumn_28_0_1']";
			public String TC022_A_CA_SERVICE_REPORTING_Services_Annualized_1=".//*[@id='ListingURE_detailView_listColumn_29_0_1']";
			public String TC022_A_CA_SERVICE_REPORTING_Services_Annualized_2=".//*[@id='ListingURE_detailView_listColumn_30_0_1']";
			public String TC022_A_CA_SERVICE_REPORTING_Services_Annualized_3=".//*[@id='ListingURE_detailView_listColumn_31_0_1']";
			public String TC023_A_CA_SERVICE_REPORTING_Services_Annualized=".//*[@id='ListingURE_detailView_listColumn_32_0_1']";
			public String TC024_A_CA_SERVICE_REPORTING_CONTRACT_CONV=".//*[@id='ListingURE_detailView_listColumn_33_0_1']";
			public String TC025_A_CA_SERVICE_ANNUALIZED_=".//*[@id='ListingURE_detailView_listColumn_34_0_1']";
			public String TC025_A_CA_SERVICE_ANNUALIZED_REPORTING=".//*[@id='ListingURE_detailView_listColumn_35_0_1']";
			public String TC025_B_CA_SERVICE_ANNUALIZED=".//*[@id='ListingURE_detailView_listColumn_36_0_1']";
			public String TC026_A_Sales_Order_Notes_Number=".//*[@id='ListingURE_detailView_listColumn_37_0_1']";
			public String TC026_B_Sales_Order_Notes_Number=".//*[@id='ListingURE_detailView_listColumn_38_0_1']";
			public String TC027_A_XAAS_ATTRIBUTES=".//*[@id='ListingURE_detailView_listColumn_39_0_1']";
			public String TC028_A_SERVICEANNUALIZED=".//*[@id='ListingURE_detailView_listColumn_40_0_1']";
			public String TC028_B_SERVICEANNUALIZED=".//*[@id='ListingURE_detailView_listColumn_41_0_1']";
			public String TC028_C_SERVICEANNUALIZED=".//*[@id='ListingURE_detailView_listColumn_42_0_1']";
			public String TC028_D_SERVICEANNUALIZED=".//*[@id='ListingURE_detailView_listColumn_43_0_1']";
			public String TC028_E_SERVICEANNUALIZED=".//*[@id='ListingURE_detailView_listColumn_44_0_1']";
			public String TC029_A_TCH_SalesOrderNote=".//*[@id='ListingURE_detailView_listColumn_45_0_1']";
			public String TC030_A_CAService_EnableTSBkngsProdBE=".//*[@id='ListingURE_detailView_listColumn_46_0_1']";
			public String TC031_A_CAService_POE=".//*[@id='ListingURE_detailView_listColumn_47_0_1']";
			public String TC031_B_CAService_POE=".//*[@id='ListingURE_detailView_listColumn_48_0_1']";
			public String TC032_A_CAService_OE=".//*[@id='ListingURE_detailView_listColumn_49_0_1']";
			public String TC032_B_CAService_OE=".//*[@id='ListingURE_detailView_listColumn_50_0_1']";
			public String TC032_C_CAService_OE=".//*[@id='ListingURE_detailView_listColumn_51_0_1']";
			public String TC033_A_CAService_CSC=".//*[@id='ListingURE_detailView_listColumn_52_0_1']";
			public String TC033_B_CAService_CSC=".//*[@id='ListingURE_detailView_listColumn_53_0_1']";
			public String TC034_A_CAService_ASBGM=".//*[@id='ListingURE_detailView_listColumn_54_0_1']";
			public String TC034_B_CAService_ASBGM=".//*[@id='ListingURE_detailView_listColumn_55_0_1']";
			public String TC035_A_Enterprise_SKU=".//*[@id='ListingURE_detailView_listColumn_56_0_1']";

			public String TC037_A_CAService_ASBGM=".//*[@id='ListingURE_detailView_listColumn_57_0_1']";
			public String TC038_A_CAService_TSSDiscounts=".//*[@id='ListingURE_detailView_listColumn_58_0_1']";
			public String TC039_B_CAService_ASBGM =".//*[@id='ListingURE_detailView_listColumn_59_0_1']";
			public String TC040_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_60_0_1']";
			public String TC040_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_61_0_1']";
			public String TC041_A_New_Renew=".//*[@id='ListingURE_detailView_listColumn_62_0_1']";
			public String TC041_B_New_Renew=".//*[@id='ListingURE_detailView_listColumn_63_0_1']";
			public String TC042_A_SubscriptionDetails=".//*[@id='ListingURE_detailView_listColumn_64_0_1']";


			public String TC043_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_65_0_1']";
			public String TC043_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_66_0_1']";
			public String TC044_A_Distributors=".//*[@id='ListingURE_detailView_listColumn_67_0_1']";
			public String TC044_B_Distributors=".//*[@id='ListingURE_detailView_listColumn_68_0_1']";
			public String TC045_A_SBPAttributes=".//*[@id='ListingURE_detailView_listColumn_69_0_1']";

			public String TC046_A_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_70_0_1']";
			public String TC047_A_Restatement=".//*[@id='ListingURE_detailView_listColumn_71_0_1']";
			public String TC047_B_Restatement=".//*[@id='ListingURE_detailView_listColumn_72_0_1']";
			public String TC048_A_MPOB=".//*[@id='ListingURE_detailView_listColumn_73_0_1']";
			public String TC049_A_POSErchmnt=".//*[@id='ListingURE_detailView_listColumn_74_0_1']";
			public String TC050_A_TSLAttribute=".//*[@id='ListingURE_detailView_listColumn_75_0_1']";
			public String TC051_A_C1Attribute=".//*[@id='ListingURE_detailView_listColumn_76_0_1']";


			/*TMS corp allocated bookings*/
			public String TC001_A_TMS_Corp_Allocated_Bookings =".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B_TMS_Corp_Allocated_Bookings =".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC001_C_TMS_Corp_Allocated_Bookings =".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC002_A_TMS_Corp_Allocated_Total_Bookings_Net =".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC003_A_TMS_Corp_Allocated_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC003_B_TMS_Corp_Allocated_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC003_C_TMS_Corp_Allocated_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC004_A_TMS_Corp_Allocated_Total_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC004_B_TMS_Corp_Allocated_Total_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC005_A_OA_BundleID_TMS_Corp_Allocated=".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC005_B_OA_BundleID_TMS_Corp_Allocated=".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC005_C_OA_BundleID_TMS_Corp_Allocated=".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC006_A_ON_SN_TMS_Corp_Allocated=".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC006_B_ON_SN_TMS_Corp_Allocated=".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC006_C_ON_SN_TMS_Corp_Allocated=".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC007_A_DSVBkngsListBkngs__DSV_Bkngs_TMS_Corp=".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC007_B_DSVBkngsListBkngs__DSV_Bkngs_TMS_Corp=".//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC008_DSV_Bkngs_TMS_Corp=".//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC009_A_RTM_TMS_Corp=".//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC010_A_TCH_Sales_Order_Notes_Number=".//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC010_B_TCH_Sales_Order_Notes_Number=".//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC011_A_TMS_TMSCorp_Subscription=".//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC011_B_TMS_TMSCorp_Subscription=".//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC012_A_TMSCorp_EnableTSBkngsProdBE=".//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC013_A_TMSCorp_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_24_0_1']";
			public String TC013_B_TMSCorp_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC013_C_TMSCorp_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC013_D_TMSCorp_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC013_E_TMSCorp_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_28_0_1']";
			public String TC014_A_TMSCorp_POE=".//*[@id='ListingURE_detailView_listColumn_29_0_1']";
			public String TC014_B_TMSCorp_POE=".//*[@id='ListingURE_detailView_listColumn_30_0_1']";
			public String TC014_C_TMSCorp_POE=".//*[@id='ListingURE_detailView_listColumn_31_0_1']";
			public String TC014_D_TMSCorp_POE=".//*[@id='ListingURE_detailView_listColumn_32_0_1']";
			public String TC015_A_Enterprise_SKU=".//*[@id='ListingURE_detailView_listColumn_33_0_1']";

			public String TC016_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_34_0_1']";
			public String TC016_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_35_0_1']";
			public String TC017_A_New_Renew=".//*[@id='ListingURE_detailView_listColumn_36_0_1']";
			public String TC017_B_New_Renew=".//*[@id='ListingURE_detailView_listColumn_37_0_1']";
			public String TC018_A_SubscriptionDetails=".//*[@id='ListingURE_detailView_listColumn_38_0_1']";
			public String TC018_B_SubscriptionDetails=".//*[@id='ListingURE_detailView_listColumn_39_0_1']";
			public String TC019_A_MLB=".//*[@id='ListingURE_detailView_listColumn_40_0_1']";
			public String TC019_B_MLB=".//*[@id='ListingURE_detailView_listColumn_41_0_1']";

			public String TC020_A_Distributors=".//*[@id='ListingURE_detailView_listColumn_42_0_1']";
			public String TC020_B_Distributors=".//*[@id='ListingURE_detailView_listColumn_43_0_1']";
			public String TC020_D_Distributors=".//*[@id='ListingURE_detailView_listColumn_44_0_1']";
			public String TC020_C_Distributors=".//*[@id='ListingURE_detailView_listColumn_45_0_1']";
			public String TC021_A_SBPAttributes=".//*[@id='ListingURE_detailView_listColumn_46_0_1']";

			public String TC022_A_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_47_0_1']";
			public String TC022_B_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_48_0_1']";
			public String TC023_A_Restatements=".//*[@id='ListingURE_detailView_listColumn_49_0_1']";
			public String TC023_B_Restatements=".//*[@id='ListingURE_detailView_listColumn_50_0_1']";
			public String TC023_C_Restatements=".//*[@id='ListingURE_detailView_listColumn_51_0_1']";
			public String TC023_D_Restatements=".//*[@id='ListingURE_detailView_listColumn_52_0_1']";
			public String TC023_E_Restatements=".//*[@id='ListingURE_detailView_listColumn_53_0_1']";
			public String TC023_F_Restatements=".//*[@id='ListingURE_detailView_listColumn_54_0_1']";
			public String TC024_A_MPOB=".//*[@id='ListingURE_detailView_listColumn_55_0_1']";
			public String TC025_A_TSLAttribute=".//*[@id='ListingURE_detailView_listColumn_56_0_1']";
			public String TC026_A_C1Attribute=".//*[@id='ListingURE_detailView_listColumn_57_0_1']";


			/*TMS sales Allocated bookings*/
			public String TC001_A_TMS_Sales_Allocated_Bookings =".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B_TMS_Sales_Allocated_Bookings =".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC001_C_TMS_Sales_Allocated_Bookings =".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC002_A_TMS_Sales_Allocated_Total_Bookings =".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC003_A_TMS_Sales_Allocated_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC003_B_TMS_Sales_Allocated_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC003_C_TMS_Sales_Allocated_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC004_A_TMS_Sales_Allocated_Total_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC004_B_TMS_Sales_Allocated_Total_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC004_C_TMS_Sales_Allocated_Total_Product_Bookings =".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC005_A_TMS_Sales_Allocated_Bookings_Adjustments =".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC005_B_TMS_Sales_Allocated_Bookings_Adjustments =".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC005_C_TMS_Sales_Allocated_Bookings_Adjustments =".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC006_A_TMS_Sales_Allocated_OA_BundlePID=".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC006_B_TMS_Sales_Allocated_OA_BundlePID=".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC006_C_TMS_Sales_Allocated_OA_BundlePID=".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC007_A_TMS_Sales_Allocated_ON_SN=".//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC007_B_TMS_Sales_Allocated_ON_SN=".//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC007_C_TMS_Sales_Allocated_ON_SN=".//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC008_A_DSVBkngsListBkngs__DSV_Bkngs_TMS_Sales=".//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC008_B_DSVBkngsListBkngs__DSV_Bkngs_TMS_Sales=".//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC009_DSV_Bkngs_TMS_Sales=".//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC010_A_RTM_TMS_Sales=".//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC010_B_RTM_TMS_Sales=".//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC011_A_TCH_Sales_Order_Notes_Number=".//*[@id='ListingURE_detailView_listColumn_24_0_1']";
			public String TC011_B_TCH_Sales_Order_Notes_Number=".//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC012_A_TMS_TMSSales_Subscription=".//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC012_B_TMS_TMSSales_Subscription=".//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC013_A_TMSSales_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_28_0_1']";
			public String TC013_B_TMSSales_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_29_0_1']";
			public String TC013_C_TMSSales_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_30_0_1']";
			public String TC013_D_TMSSales_OEHierarchy=".//*[@id='ListingURE_detailView_listColumn_31_0_1']";
			public String TC014_A_TMSSales_POE=".//*[@id='ListingURE_detailView_listColumn_32_0_1']";
			public String TC014_B_TMSSales_POE=".//*[@id='ListingURE_detailView_listColumn_33_0_1']";
			public String TC014_C_TMSSales_POE=".//*[@id='ListingURE_detailView_listColumn_34_0_1']";
			public String TC014_D_TMSSales_POE=".//*[@id='ListingURE_detailView_listColumn_35_0_1']";
			public String TC015_A_Enterprise_SKU1=".//*[@id='ListingURE_detailView_listColumn_36_0_1']";

			public String TC016_A_TMSSalesPOSEnrichment=".//*[@id='ListingURE_detailView_listColumn_37_0_1']";
			public String TC016_B_TMSSalesPOSEnrichment=".//*[@id='ListingURE_detailView_listColumn_38_0_1']";
			public String TC017_A_TMSSalesNew_Renew=".//*[@id='ListingURE_detailView_listColumn_39_0_1']";
			public String TC017_B_TMSSalesNew_Renew=".//*[@id='ListingURE_detailView_listColumn_40_0_1']";
			public String TC018_A_TMSSalesSubscriptionDetails=".//*[@id='ListingURE_detailView_listColumn_41_0_1']";
			public String TC018_B_TMSSalesSubscriptionDetails=".//*[@id='ListingURE_detailView_listColumn_42_0_1']";
			public String TC019_A_TMSSalesMLB=".//*[@id='ListingURE_detailView_listColumn_43_0_1']";
			public String TC019_B_TMSSalesMLB=".//*[@id='ListingURE_detailView_listColumn_44_0_1']";

			public String TC020_A_TMSSalesDistributors=".//*[@id='ListingURE_detailView_listColumn_45_0_1']";
			public String TC020_B_TMSSalesDistributors=".//*[@id='ListingURE_detailView_listColumn_46_0_1']";
			public String TC020_C_TMSSalesDistributors=".//*[@id='ListingURE_detailView_listColumn_47_0_1']";
			public String TC020_D_TMSSalesDistributors=".//*[@id='ListingURE_detailView_listColumn_48_0_1']";
			public String TC021_A_TMSSalesSBPAttributes=".//*[@id='ListingURE_detailView_listColumn_49_0_1']";

			public String TC022_A_TMSSalesROAttributes=".//*[@id='ListingURE_detailView_listColumn_50_0_1']";
			public String TC022_B_TMSSalesROAttributes=".//*[@id='ListingURE_detailView_listColumn_51_0_1']";
			public String TC023_A_TMSSalesRestatement=".//*[@id='ListingURE_detailView_listColumn_52_0_1']";
			public String TC023_B_TMSSalesRestatement=".//*[@id='ListingURE_detailView_listColumn_53_0_1']";
			public String TC023_C_TMSSalesRestatement=".//*[@id='ListingURE_detailView_listColumn_54_0_1']";
			public String TC023_D_TMSSalesRestatement=".//*[@id='ListingURE_detailView_listColumn_55_0_1']";
			public String TC023_E_TMSSalesRestatement=".//*[@id='ListingURE_detailView_listColumn_56_0_1']";
			public String TC023_F_TMSSalesRestatement=".//*[@id='ListingURE_detailView_listColumn_57_0_1']";
			//public String TC024_A_TMSSalesMPOB=".//*[@id='ListingURE_detailView_listColumn_58_0_1']";
			public String TC025_A_TMS_Sales_TSLAttribute=".//*[@id='ListingURE_detailView_listColumn_59_0_1']";
			//public String TC026_A_TMS_Sales_C1Attribute=".//*[@id='ListingURE_detailView_listColumn_60_0_1']";



		/*Revenue Reporting*/
			public String TC001_A__REVENUE ="//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B__REVENUE ="//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC002_TOTAL__REVENUE ="//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC003_A__PnL_GM ="//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC003_B__PnL_GM ="//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC004_A_DEBIT_MEMO_GL ="//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC004_B_DEBIT_MEMO_GL ="//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC004_C_DEBIT_MEMO_GL ="//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC005_A_DEBIT_MEMO_INVOICE ="//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC005_B_DEBIT_MEMO_INVOICE ="//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC005_C_DEBIT_MEMO_INVOICE ="//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC006_A_GROSS_MARGIN_GL ="//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC006_B_GROSS_MARGIN_GL ="//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC006_C_GROSS_MARGIN_GL ="//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC007_A_GROSS_MARGIN_INVOICE ="//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC007_B_GROSS_MARGIN_INVOICE ="//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC007_C_GROSS_MARGIN_INVOICE ="//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC008_ACQUISITION_DETAILS ="//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC009_CONTRIBUTION_MARGIN ="//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC010_CONTRIBUTION_MARGIN_BUDGET ="//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC011_A__INVOICE ="//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC011_B__INVOICE ="//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC011_C__INVOICE ="//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC012_CONTRIBUTION_MARGIN_COMMIT ="//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC013_A_CREDIT_MEMO_GL ="//*[@id='ListingURE_detailView_listColumn_24_0_1']";
			public String TC013_B_CREDIT_MEMO_GL ="//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC013_C_CREDIT_MEMO_GL ="//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC014_Total__PnL_GM ="//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC015_A_CREDIT_MEMO_INVOICE ="//*[@id='ListingURE_detailView_listColumn_28_0_1']";
			public String TC015_B_CREDIT_MEMO_INVOICE ="//*[@id='ListingURE_detailView_listColumn_29_0_1']";
			public String TC015_C_CREDIT_MEMO_INVOICE ="//*[@id='ListingURE_detailView_listColumn_30_0_1']";
			public String TC016_A_OA_BunPID_Revenue="//*[@id='ListingURE_detailView_listColumn_31_0_1']";
			public String TC016_B_OA_BunPID_Revenue="//*[@id='ListingURE_detailView_listColumn_32_0_1']";
			public String TC017_OA_BunPID_Invoice="//*[@id='ListingURE_detailView_listColumn_33_0_1']";
			public String TC018_B_Sub_Inv_Org_Code_Invoice="//*[@id='ListingURE_detailView_listColumn_34_0_1']";
			public String TC018_A_Sub_Inv_Org_Code_Revenue="//*[@id='ListingURE_detailView_listColumn_35_0_1']";
			public String TC019_EnableSO_Revenue="//*[@id='ListingURE_detailView_listColumn_36_0_1']";
			public String TC020_EnableSO_INVOICE="//*[@id='ListingURE_detailView_listColumn_37_0_1']";
			public String TC021_EnableSo_SOLineId_Revenue="//*[@id='ListingURE_detailView_listColumn_38_0_1']";
			public String TC022_EnableSO_SO_Line_id_INVOICE="//*[@id='ListingURE_detailView_listColumn_39_0_1']";
			public String TC023_CERussia_LocalTrxDt_Revenue="//*[@id='ListingURE_detailView_listColumn_40_0_1']";
			public String TC024_CERussia_Localtrxnnum_Revenue="//*[@id='ListingURE_detailView_listColumn_41_0_1']";
			public String TC025_CERussia_AOAIssuanceDate_Revenue="//*[@id='ListingURE_detailView_listColumn_42_0_1']";
			public String TC026_CERussia_AOANumber_Revenue="//*[@id='ListingURE_detailView_listColumn_43_0_1']";
			public String TC027_CERussia_UpforntBillingFlag_Revenue="//*[@id='ListingURE_detailView_listColumn_44_0_1']";
			public String TC028_CERussia_LocalCorrectionnum_Revenue="//*[@id='ListingURE_detailView_listColumn_45_0_1']";
			public String TC029_CERussia_LocalSONum_Revenue="//*[@id='ListingURE_detailView_listColumn_46_0_1']";
			public String TC030_CERussia_LocalTrxndate_INVOICE="//*[@id='ListingURE_detailView_listColumn_47_0_1']";
			public String TC031_CERussia_LocalTrxnnum_INVOICE="//*[@id='ListingURE_detailView_listColumn_48_0_1']";
			public String TC032_CERussia_AOAIssuanceNum_INVOICE="//*[@id='ListingURE_detailView_listColumn_49_0_1']";
			public String TC033_CERussia_AOANum_INVOICE="//*[@id='ListingURE_detailView_listColumn_50_0_1']";
			public String TC034_CERussia_LocalCorrectionNum_INVOICE="//*[@id='ListingURE_detailView_listColumn_51_0_1']";
			public String TC035_CERussia_LocalSOnum_INVOICE="//*[@id='ListingURE_detailView_listColumn_52_0_1']";
			public String TC036_A_Addtional_SaaS_Attributes="//*[@id='ListingURE_detailView_listColumn_53_0_1']";
			public String TC036_B_Additional_SaaS_Attributes="//*[@id='ListingURE_detailView_listColumn_54_0_1']";
			public String TC037_A_SaaS_Attributes="//*[@id='ListingURE_detailView_listColumn_55_0_1']";
			public String TC037_B_SaaS_Attributes="//*[@id='ListingURE_detailView_listColumn_56_0_1']";
			public String TC038_A_OE_Hierarchy_Revenue="//*[@id='ListingURE_detailView_listColumn_57_0_1']";
			public String TC038_B_OE_Hierarchy_Revenue="//*[@id='ListingURE_detailView_listColumn_58_0_1']";
			public String TC039_A_FCM_Revenue="//*[@id='ListingURE_detailView_listColumn_59_0_1']";
			public String TC039_B_FCM_Revenue="//*[@id='ListingURE_detailView_listColumn_60_0_1']";
			public String TC039_C_FCM_Revenue="//*[@id='ListingURE_detailView_listColumn_61_0_1']";
			public String TC039_D_FCM_Revenue="//*[@id='ListingURE_detailView_listColumn_62_0_1']";
			public String TC040_A_POE_Revenue="//*[@id='ListingURE_detailView_listColumn_63_0_1']";
			public String TC041_A_POE_Revenue="//*[@id='ListingURE_detailView_listColumn_64_0_1']";

			public String TC042_CE_CHINA_CFN="//*[@id='ListingURE_detailView_listColumn_65_0_1']";
			public String TC043_A_Bundle_OA_Attributes="//*[@id='ListingURE_detailView_listColumn_66_0_1']";
			public String TC044_A_ENTERPRISE_SKU="//*[@id='ListingURE_detailView_listColumn_67_0_1']";

			public String TC045_A_MPOB="//*[@id='ListingURE_detailView_listColumn_68_0_1']";



			/*TMS Reporting */
			public String TC001_A_TMS_Corp_Allocated_Revenue=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B_TMS_Corp_Allocated_Revenue=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC002_A_TMS_Corp_Allocated_Quantity=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC003_A_TMS_Corp_Allocated_Revenue_Ports=".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC004_A_TMS_GROSS_MARGIN=".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC005_A_TMS_SALES_ALLOCATED_INVOICE=".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC006_A_POE_TMSReporting=".//*[@id='ListingURE_detailView_listColumn_6_0_1']";


			/*CA Service Reporting */
			public String TC001_A_CA_Service_Reporting=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B_CA_Service_Reporting=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC002_A_CA_Service_INVOICE=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC002_B_CA_Service_INVOICE=".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC003_Total__CA_Service=".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC004_A_Service_Acquisition_Details=".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC005_EnableSO_Revenue=".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC006_EnableSO_INVOICE=".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC007_EnableSO_SOLineId_Revenue=".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC008_EnableSO_SO_Line_id_INVOICE=".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC009_CERussia_Localtrxndate_Revenue=".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC010_CERussia_Localtrxnnum_Revenue=".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC011_CERussia_AOAIssuanceDate_Revenue=".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC012_CERussia_AOANum_Revenue=".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC013_CERussia_upfrontBillingflag_Revenue=".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC014_CERussia_LocalCorretionnum_Revenue=".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC015_CERussia_LocalSoNum_Revenue=".//*[@id='ListingURE_detailView_listColumn_16_0_1']";
			public String TC016_CERussia_LocalTrxnDate_INVOICE=".//*[@id='ListingURE_detailView_listColumn_17_0_1']";
			public String TC017_CERussia_AOAIssuancedate_INVOICE=".//*[@id='ListingURE_detailView_listColumn_18_0_1']";
			public String TC018_CERussia_Localtrxnnumber_INVOICE=".//*[@id='ListingURE_detailView_listColumn_19_0_1']";
			public String TC019_CERussia_AOANum_INVOICE=".//*[@id='ListingURE_detailView_listColumn_20_0_1']";
			public String TC020_CERussia_UpfrontBillingflag_INVOICE=".//*[@id='ListingURE_detailView_listColumn_21_0_1']";
			public String TC021_CERussia_LocalCorrectionNum_INVOICE=".//*[@id='ListingURE_detailView_listColumn_22_0_1']";
			public String TC022_CERussia_LocalSONum_INVOICE=".//*[@id='ListingURE_detailView_listColumn_23_0_1']";
			public String TC023_A_OE_Hierarchy=".//*[@id='ListingURE_detailView_listColumn_24_0_1']";

			public String TC024_A_CMS=".//*[@id='ListingURE_detailView_listColumn_25_0_1']";
			public String TC024_B_CMS=".//*[@id='ListingURE_detailView_listColumn_26_0_1']";
			public String TC024_C_CMS=".//*[@id='ListingURE_detailView_listColumn_27_0_1']";
			public String TC025_A_New_Renew=".//*[@id='ListingURE_detailView_listColumn_28_0_1']";

			public String TC026_A_MPOB=".//*[@id='ListingURE_detailView_listColumn_29_0_1']";

			/*Revenue Common Objects Reporting */
			public String TC001_A_REVENUE_REPORTING_NEW_RENEW=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B_REVENUE_REPORTING_NEW_RENEW=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";



			/*Revenue Forecast Reporting */
			public String TC001_REVENUE_BUDGET=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC002_REVENUE_COMMIT=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC003_REVENUE_UPDATE=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC004_REVENUE_OUTLOOK=".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC005_REVENUE_BUDGET_PREOWNED=".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC006_REVENUEFORECAT_PREOWNED=".//*[@id='ListingURE_detailView_listColumn_5_0_1']";

			/* Deferred Revenue Reporting */
			public String TC001_A_EnableSO_Deffered_Revenue=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC002_B_EnableSO_SOLineId_Deffered_Revenue=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC003_A_CERussia_LocalTrxnDate_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC004_A_CERussia_LocalTrxnNum_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC005_A_CERussia_AOAIssuanceDate_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_4_0_1']";
			public String TC006_A_CERussia_AOANum_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC007_A_CERussia_LocalCorrectionNum_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC008_A_CERussia_LocalSONum_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC009_A_CERussia_UpfrontBookingflag_DefferedRevenue=".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC010_A_POE_DeferredRevenue=".//*[@id='ListingURE_detailView_listColumn_9_0_1']";


			/*Service P&D Reporting*/
			public String TC001_A_INSTANCE_LEVEL=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_A_POS_ENRICHMENT=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC002_A_POSEnrhmnt_tracability=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";

			/*Service CommonObjects Reporting*/
			public String TC001_A_NEW_RENEW=".//*[@id='ListingURE_detailView_listColumn_0_0_1']";
			public String TC001_B_NEW_RENEW=".//*[@id='ListingURE_detailView_listColumn_1_0_1']";
			public String TC001_C_NEW_RENEW=".//*[@id='ListingURE_detailView_listColumn_2_0_1']";
			public String TC002_A_INSTANCE_LEVEL=".//*[@id='ListingURE_detailView_listColumn_3_0_1']";
			public String TC003_A_SALESMOTIONCONTEXT=".//*[@id='ListingURE_detailView_listColumn_4_0_1']";

			public String TC004_A_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_5_0_1']";
			public String TC004_B_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_6_0_1']";
			public String TC004_C_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_7_0_1']";
			public String TC004_D_POSEnrichment=".//*[@id='ListingURE_detailView_listColumn_8_0_1']";
			public String TC005_B_SBPAttributesReporting=".//*[@id='ListingURE_detailView_listColumn_9_0_1']";
			public String TC005_A_SBPAttributesReporting=".//*[@id='ListingURE_detailView_listColumn_10_0_1']";
			public String TC005_C_SBPAttributesReporting=".//*[@id='ListingURE_detailView_listColumn_11_0_1']";
			public String TC005_D_SBPAttributesReporting=".//*[@id='ListingURE_detailView_listColumn_12_0_1']";
			public String TC006_A_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_13_0_1']";
			public String TC006_B_ROAttributes=".//*[@id='ListingURE_detailView_listColumn_14_0_1']";
			public String TC007_A_POSEnrchmnt_traceability=".//*[@id='ListingURE_detailView_listColumn_15_0_1']";
			public String TC008_A_TSLAttribute=".//*[@id='ListingURE_detailView_listColumn_16_0_1']";



			/*Revenue Folder Navigation*/

			public String FinanceRevenue ="//*[@id='accordionNavigationView_drawer1_treeView_treeNode59_name']";
			public String RevenueAutomation = "//*[@id='accordionNavigationView_drawer1_treeView_treeNode63_name']";
			public String RevenueBOFolder = "//*[@id='accordionNavigationView_drawer1_treeView_treeNode86_name']";
			public String RevenueReportingFolder = "//*[@id='accordionNavigationView_drawer1_treeView_treeNode87_name']";
			public String RevenueCAServiceReporting="//*[@id='accordionNavigationView_drawer1_treeView_treeNode88_name']";
			public String DefferedRevenueReportingFolder="//*[@id='accordionNavigationView_drawer1_treeView_treeNode89_name']";
			public String RevenueForecastReporting="//*[@id='accordionNavigationView_drawer1_treeView_treeNode90_name']";
			public String RevenueTMSReportingFolder=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode91_name']";
			public String RevenueCommonObjectsReportingFolder=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode92_name']";


	/*Demo folder for Revenue*/

	public String DemoFolder =".//*[@id='accordionNavigationView_drawer1_treeView_treeNode91_name']" ;
	public String TC001_Pass_Scenario = "//*[@id='ListingURE_detailView_listColumn_0_0_1']";
	public String TC002_Fail_Scenario = "//*[@id='ListingURE_detailView_listColumn_1_0_1']";

	/*Bookings Folder Navigation*/

	public String CompatibilityAutomationFolder="//*[@id='accordionNavigationView_drawer1_treeView_treeNode61_name']";
	public String FinanceBookings=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode3_name']";
	public String BookingsAutomation =".//*[@id='accordionNavigationView_drawer1_treeView_treeNode8_name']";
	public String BookingsBOFolder=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode81_name']";
	public String BookingsReporting=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode83_name']";
	public String BookingsReporting1=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode82_name']";
	public String BookingsCAServiceReporting=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode82_name']";
	public String BookingsChannelsReporting =".//*[@id='accordionNavigationView_drawer1_treeView_treeNode83_name']";
	public String BookingsTMSReporting=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode84_name']";
	public String BookingsTMSSales=".//*[@id='accordionNavigationView_drawer1_treeView_treeNode85_name']";
	public String BookingsDemo="//*[@id='accordionNavigationView_drawer1_treeView_treeNode165_name']";
	public String BookingsServicePnDReporting =".//*[@id='accordionNavigationView_drawer1_treeView_treeNode86_name']";
	public String BookingsCommonObjectsReporting =".//*[@id='accordionNavigationView_drawer1_treeView_treeNode87_name']";




}
