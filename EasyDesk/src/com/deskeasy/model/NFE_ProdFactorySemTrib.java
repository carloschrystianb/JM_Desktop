package com.deskeasy.model;

public class NFE_ProdFactorySemTrib extends NFE_Prod{
	
	public static String FISCAL_CFOP = "5405";
	public static String FISCAL_ICMS_Orig = "0";
	public static String FISCAL_ICMS_CSOSN = "500";
	public static String FISCAL_PIS_CTS = "07";
	public static String FISCAL_CONFINS_CIS = "07";
	
	
	public NFE_ProdFactorySemTrib(HNG_Item hngItem, String nNF, String vDesc){
		super.setnNF(nNF);
		super.setnItem("" + hngItem.getnItem());
		super.setcProd(hngItem.getCodProd());
		super.setxProd(hngItem.getDescricaoProduto());
		super.setNcm("87082999");
		super.setuCom(hngItem.getUnit());
		super.setqCom(hngItem.getQuantidade());
		super.setvUnCom(hngItem.getvUnit());
		super.setvProd(hngItem.getvTotal());
		super.setuTrib(hngItem.getUnit());
		super.setqTrib(hngItem.getQuantidade());
		super.setvUnTrib(hngItem.getvUnit());
		super.setIndTot("1");
		super.setCfop(FISCAL_CFOP);
		super.setIcms_csosn(FISCAL_ICMS_CSOSN);
		super.setIcms_orig(FISCAL_ICMS_Orig);
		super.setPis_cts(FISCAL_PIS_CTS);
		super.setCofins_cst(FISCAL_CONFINS_CIS);
		super.setvDesc(vDesc);
	}
}
