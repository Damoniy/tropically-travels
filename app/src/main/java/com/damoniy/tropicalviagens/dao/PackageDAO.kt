package com.damoniy.tropicalviagens.dao

import java.math.BigDecimal
import com.damoniy.tropicalviagens.model.Pack

class PackageDAO {

    val packageList =
        arrayListOf(Pack("São Paulo", "sao_paulo_sp", 2, BigDecimal(239.90)),
            Pack("Belo Horizonte", "belo_horizonte_mg", 2, BigDecimal(239.90)),
            Pack("Foz do Igaçu", "foz_do_iguacu_pr", 5, BigDecimal(599.00)),
            Pack("Recife", "recife_pe", 1, BigDecimal(199.00)),
            Pack("Salvador", "salvador_ba", 3, BigDecimal(349.00))
            )
}