package com.mf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matej on 10/28/2016.
 */
public class Products {

    public static final String IND_AHOR_FIN_ULT1 = "ind_ahor_fin_ult1";
    public static final String IND_AVAL_FIN_ULT1 = "ind_aval_fin_ult1";
    public static final String IND_CCO_FIN_ULT1 = "ind_cco_fin_ult1";
    public static final String IND_CDER_FIN_ULT1 = "ind_cder_fin_ult1";
    public static final String IND_CNO_FIN_ULT1 = "ind_cno_fin_ult1";
    public static final String IND_CTJU_FIN_ULT1 = "ind_ctju_fin_ult1";
    public static final String IND_CTMA_FIN_ULT1 = "ind_ctma_fin_ult1";
    public static final String IND_CTOP_FIN_ULT1 = "ind_ctop_fin_ult1";
    public static final String IND_CTPP_FIN_ULT1 = "ind_ctpp_fin_ult1";
    public static final String IND_DECO_FIN_ULT1 = "ind_deco_fin_ult1";
    public static final String IND_DEME_FIN_ULT1 = "ind_deme_fin_ult1";
    public static final String IND_DELA_FIN_ULT1 = "ind_dela_fin_ult1";
    public static final String IND_ECUE_FIN_ULT1 = "ind_ecue_fin_ult1";
    public static final String IND_FOND_FIN_ULT1 = "ind_fond_fin_ult1";
    public static final String IND_HIP_FIN_ULT1 = "ind_hip_fin_ult1";
    public static final String IND_PLAN_FIN_ULT1 = "ind_plan_fin_ult1";
    public static final String IND_PRES_FIN_ULT1 = "ind_pres_fin_ult1";
    public static final String IND_RECA_FIN_ULT1 = "ind_reca_fin_ult1";
    public static final String IND_TJCR_FIN_ULT1 = "ind_tjcr_fin_ult1";
    public static final String IND_VALO_FIN_ULT1 = "ind_valo_fin_ult1";
    public static final String IND_VIV_FIN_ULT1 = "ind_viv_fin_ult1";
    public static final String IND_NOMINA_ULT1 = "ind_nomina_ult1";
    public static final String IND_NOM_PENS_ULT1 = "ind_nom_pens_ult1";
    public static final String IND_RECIBO_ULT1 = "ind_recibo_ult1";

    public static final List<String> ALL = Arrays.asList(IND_AHOR_FIN_ULT1,
            IND_AVAL_FIN_ULT1,
            IND_CCO_FIN_ULT1,
            IND_CDER_FIN_ULT1,
            IND_CNO_FIN_ULT1,
            IND_CTJU_FIN_ULT1,
            IND_CTMA_FIN_ULT1,
            IND_CTOP_FIN_ULT1,
            IND_CTPP_FIN_ULT1,
            IND_DECO_FIN_ULT1,
            IND_DEME_FIN_ULT1,
            IND_DELA_FIN_ULT1,
            IND_ECUE_FIN_ULT1,
            IND_FOND_FIN_ULT1,
            IND_HIP_FIN_ULT1,
            IND_PLAN_FIN_ULT1,
            IND_PRES_FIN_ULT1,
            IND_RECA_FIN_ULT1,
            IND_TJCR_FIN_ULT1,
            IND_VALO_FIN_ULT1,
            IND_VIV_FIN_ULT1,
            IND_NOMINA_ULT1,
            IND_NOM_PENS_ULT1,
            IND_RECIBO_ULT1);

    public static List<String> MOST_COMMON_PRODUCTS = Arrays.asList(IND_CCO_FIN_ULT1, IND_CTOP_FIN_ULT1, IND_RECIBO_ULT1, IND_ECUE_FIN_ULT1,
            IND_CNO_FIN_ULT1, IND_RECA_FIN_ULT1, IND_TJCR_FIN_ULT1);

    public boolean ind_ahor_fin_ult1;
    public boolean ind_aval_fin_ult1;
    public boolean ind_cco_fin_ult1;
    public boolean ind_cder_fin_ult1;
    public boolean ind_cno_fin_ult1;
    public boolean ind_ctju_fin_ult1;
    public boolean ind_ctma_fin_ult1;
    public boolean ind_ctop_fin_ult1;
    public boolean ind_ctpp_fin_ult1;
    public boolean ind_deco_fin_ult1;
    public boolean ind_deme_fin_ult1;
    public boolean ind_dela_fin_ult1;
    public boolean ind_ecue_fin_ult1;
    public boolean ind_fond_fin_ult1;
    public boolean ind_hip_fin_ult1;
    public boolean ind_plan_fin_ult1;
    public boolean ind_pres_fin_ult1;
    public boolean ind_reca_fin_ult1;
    public boolean ind_tjcr_fin_ult1;
    public boolean ind_valo_fin_ult1;
    public boolean ind_viv_fin_ult1;
    public boolean ind_nomina_ult1;
    public boolean ind_nom_pens_ult1;
    public boolean ind_recibo_ult1;

    public Products(String s1,
                    String s2,
                    String s3,
                    String s4,
                    String s5,
                    String s6,
                    String s7,
                    String s8,
                    String s9,
                    String s10,
                    String s11,
                    String s12,
                    String s13,
                    String s14,
                    String s15,
                    String s16,
                    String s17,
                    String s18,
                    String s19,
                    String s20,
                    String s21,
                    String s22,
                    String s23,
                    String s24) {
        ind_ahor_fin_ult1 = s1.equals("1");
        ind_aval_fin_ult1 = s2.equals("1");
        ind_cco_fin_ult1 = s3.equals("1");
        ind_cder_fin_ult1 = s4.equals("1");
        ind_cno_fin_ult1 = s5.equals("1");
        ind_ctju_fin_ult1 = s6.equals("1");
        ind_ctma_fin_ult1 = s7.equals("1");
        ind_ctop_fin_ult1 = s8.equals("1");
        ind_ctpp_fin_ult1 = s9.equals("1");
        ind_deco_fin_ult1 = s10.equals("1");
        ind_deme_fin_ult1 = s11.equals("1");
        ind_dela_fin_ult1 = s12.equals("1");
        ind_ecue_fin_ult1 = s13.equals("1");
        ind_fond_fin_ult1 = s14.equals("1");
        ind_hip_fin_ult1 = s15.equals("1");
        ind_plan_fin_ult1 = s16.equals("1");
        ind_pres_fin_ult1 = s17.equals("1");
        ind_reca_fin_ult1 = s18.equals("1");
        ind_tjcr_fin_ult1 = s19.equals("1");
        ind_valo_fin_ult1 = s20.equals("1");
        ind_viv_fin_ult1 = s21.equals("1");
        ind_nomina_ult1 = s22.equals("1");
        ind_nom_pens_ult1 = s23.equals("1");
        ind_recibo_ult1 = s24.equals("1");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (ind_ahor_fin_ult1 != products.ind_ahor_fin_ult1) return false;
        if (ind_aval_fin_ult1 != products.ind_aval_fin_ult1) return false;
        if (ind_cco_fin_ult1 != products.ind_cco_fin_ult1) return false;
        if (ind_cder_fin_ult1 != products.ind_cder_fin_ult1) return false;
        if (ind_cno_fin_ult1 != products.ind_cno_fin_ult1) return false;
        if (ind_ctju_fin_ult1 != products.ind_ctju_fin_ult1) return false;
        if (ind_ctma_fin_ult1 != products.ind_ctma_fin_ult1) return false;
        if (ind_ctop_fin_ult1 != products.ind_ctop_fin_ult1) return false;
        if (ind_ctpp_fin_ult1 != products.ind_ctpp_fin_ult1) return false;
        if (ind_deco_fin_ult1 != products.ind_deco_fin_ult1) return false;
        if (ind_deme_fin_ult1 != products.ind_deme_fin_ult1) return false;
        if (ind_dela_fin_ult1 != products.ind_dela_fin_ult1) return false;
        if (ind_ecue_fin_ult1 != products.ind_ecue_fin_ult1) return false;
        if (ind_fond_fin_ult1 != products.ind_fond_fin_ult1) return false;
        if (ind_hip_fin_ult1 != products.ind_hip_fin_ult1) return false;
        if (ind_plan_fin_ult1 != products.ind_plan_fin_ult1) return false;
        if (ind_pres_fin_ult1 != products.ind_pres_fin_ult1) return false;
        if (ind_reca_fin_ult1 != products.ind_reca_fin_ult1) return false;
        if (ind_tjcr_fin_ult1 != products.ind_tjcr_fin_ult1) return false;
        if (ind_valo_fin_ult1 != products.ind_valo_fin_ult1) return false;
        if (ind_viv_fin_ult1 != products.ind_viv_fin_ult1) return false;
        if (ind_nomina_ult1 != products.ind_nomina_ult1) return false;
        if (ind_nom_pens_ult1 != products.ind_nom_pens_ult1) return false;
        return ind_recibo_ult1 == products.ind_recibo_ult1;

    }

    @Override
    public int hashCode() {
        int result = (ind_ahor_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_aval_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_cco_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_cder_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_cno_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_ctju_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_ctma_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_ctop_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_ctpp_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_deco_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_deme_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_dela_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_ecue_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_fond_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_hip_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_plan_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_pres_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_reca_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_tjcr_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_valo_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_viv_fin_ult1 ? 1 : 0);
        result = 31 * result + (ind_nomina_ult1 ? 1 : 0);
        result = 31 * result + (ind_nom_pens_ult1 ? 1 : 0);
        result = 31 * result + (ind_recibo_ult1 ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return booleanToString(ind_ahor_fin_ult1) +
                booleanToString(ind_aval_fin_ult1) +
                booleanToString(ind_cco_fin_ult1) +
                booleanToString(ind_cder_fin_ult1) +
                booleanToString(ind_cno_fin_ult1) +
                booleanToString(ind_ctju_fin_ult1) +
                booleanToString(ind_ctma_fin_ult1) +
                booleanToString(ind_ctop_fin_ult1) +
                booleanToString(ind_ctpp_fin_ult1) +
                booleanToString(ind_deco_fin_ult1) +
                booleanToString(ind_deme_fin_ult1) +
                booleanToString(ind_dela_fin_ult1) +
                booleanToString(ind_ecue_fin_ult1) +
                booleanToString(ind_fond_fin_ult1) +
                booleanToString(ind_hip_fin_ult1) +
                booleanToString(ind_plan_fin_ult1) +
                booleanToString(ind_pres_fin_ult1) +
                booleanToString(ind_reca_fin_ult1) +
                booleanToString(ind_tjcr_fin_ult1) +
                booleanToString(ind_valo_fin_ult1) +
                booleanToString(ind_viv_fin_ult1) +
                booleanToString(ind_nomina_ult1) +
                booleanToString(ind_nom_pens_ult1) +
                booleanToString(ind_recibo_ult1);
    }

    private String booleanToString(boolean b) {
        return b ? "1" : "0";
    }

    public List<String> toList() {
        List<String> result = new ArrayList<>();
        if (ind_ahor_fin_ult1) result.add(IND_AHOR_FIN_ULT1);
        if (ind_aval_fin_ult1) result.add(IND_AVAL_FIN_ULT1);
        if (ind_cco_fin_ult1) result.add(IND_CCO_FIN_ULT1);
        if (ind_cder_fin_ult1) result.add(IND_CDER_FIN_ULT1);
        if (ind_cno_fin_ult1) result.add(IND_CNO_FIN_ULT1);
        if (ind_ctju_fin_ult1) result.add(IND_CTJU_FIN_ULT1);
        if (ind_ctma_fin_ult1) result.add(IND_CTMA_FIN_ULT1);
        if (ind_ctop_fin_ult1) result.add(IND_CTOP_FIN_ULT1);
        if (ind_ctpp_fin_ult1) result.add(IND_CTPP_FIN_ULT1);
        if (ind_deco_fin_ult1) result.add(IND_DECO_FIN_ULT1);
        if (ind_deme_fin_ult1) result.add(IND_DEME_FIN_ULT1);
        if (ind_dela_fin_ult1) result.add(IND_DELA_FIN_ULT1);
        if (ind_ecue_fin_ult1) result.add(IND_ECUE_FIN_ULT1);
        if (ind_fond_fin_ult1) result.add(IND_FOND_FIN_ULT1);
        if (ind_hip_fin_ult1) result.add(IND_HIP_FIN_ULT1);
        if (ind_plan_fin_ult1) result.add(IND_PLAN_FIN_ULT1);
        if (ind_pres_fin_ult1) result.add(IND_PRES_FIN_ULT1);
        if (ind_reca_fin_ult1) result.add(IND_RECA_FIN_ULT1);
        if (ind_tjcr_fin_ult1) result.add(IND_TJCR_FIN_ULT1);
        if (ind_valo_fin_ult1) result.add(IND_VALO_FIN_ULT1);
        if (ind_viv_fin_ult1) result.add(IND_VIV_FIN_ULT1);
        if (ind_nomina_ult1) result.add(IND_NOMINA_ULT1);
        if (ind_nom_pens_ult1) result.add(IND_NOM_PENS_ULT1);
        if (ind_recibo_ult1) result.add(IND_RECIBO_ULT1);
        return result;
    }

    public List<String> subtract(Products products) {
        List<String> result = new ArrayList<>();
        if (ind_ahor_fin_ult1 && !products.ind_ahor_fin_ult1) result.add(IND_AHOR_FIN_ULT1);
        if (ind_aval_fin_ult1 && !products.ind_aval_fin_ult1) result.add(IND_AVAL_FIN_ULT1);
        if (ind_cco_fin_ult1  && !products.ind_cco_fin_ult1) result.add(IND_CCO_FIN_ULT1);
        if (ind_cder_fin_ult1 && !products.ind_cder_fin_ult1) result.add(IND_CDER_FIN_ULT1);
        if (ind_cno_fin_ult1  && !products.ind_cno_fin_ult1) result.add(IND_CNO_FIN_ULT1);
        if (ind_ctju_fin_ult1 && !products.ind_ctju_fin_ult1) result.add(IND_CTJU_FIN_ULT1);
        if (ind_ctma_fin_ult1 && !products.ind_ctma_fin_ult1) result.add(IND_CTMA_FIN_ULT1);
        if (ind_ctop_fin_ult1 && !products.ind_ctop_fin_ult1) result.add(IND_CTOP_FIN_ULT1);
        if (ind_ctpp_fin_ult1 && !products.ind_ctpp_fin_ult1) result.add(IND_CTPP_FIN_ULT1);
        if (ind_deco_fin_ult1 && !products.ind_deco_fin_ult1) result.add(IND_DECO_FIN_ULT1);
        if (ind_deme_fin_ult1 && !products.ind_deme_fin_ult1) result.add(IND_DEME_FIN_ULT1);
        if (ind_dela_fin_ult1 && !products.ind_dela_fin_ult1) result.add(IND_DELA_FIN_ULT1);
        if (ind_ecue_fin_ult1 && !products.ind_ecue_fin_ult1) result.add(IND_ECUE_FIN_ULT1);
        if (ind_fond_fin_ult1 && !products.ind_fond_fin_ult1) result.add(IND_FOND_FIN_ULT1);
        if (ind_hip_fin_ult1  && !products.ind_hip_fin_ult1) result.add(IND_HIP_FIN_ULT1);
        if (ind_plan_fin_ult1 && !products.ind_plan_fin_ult1) result.add(IND_PLAN_FIN_ULT1);
        if (ind_pres_fin_ult1 && !products.ind_pres_fin_ult1) result.add(IND_PRES_FIN_ULT1);
        if (ind_reca_fin_ult1 && !products.ind_reca_fin_ult1) result.add(IND_RECA_FIN_ULT1);
        if (ind_tjcr_fin_ult1 && !products.ind_tjcr_fin_ult1) result.add(IND_TJCR_FIN_ULT1);
        if (ind_valo_fin_ult1 && !products.ind_valo_fin_ult1) result.add(IND_VALO_FIN_ULT1);
        if (ind_viv_fin_ult1  && !products.ind_viv_fin_ult1) result.add(IND_VIV_FIN_ULT1);
        if (ind_nomina_ult1   && !products.ind_nomina_ult1) result.add(IND_NOMINA_ULT1);
        if (ind_nom_pens_ult1 && !products.ind_nom_pens_ult1) result.add(IND_NOM_PENS_ULT1);
        if (ind_recibo_ult1   && !products.ind_recibo_ult1) result.add(IND_RECIBO_ULT1);
        return result;
    }
}
