package com.payetonkawa.produitservice.util;

import ch.qos.logback.core.net.server.Client;
import com.opencsv.bean.CsvToBeanBuilder;
import com.payetonkawa.produitservice.model.Produit;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;
import java.util.List;

public class CsvLoader {

    public static List<Produit> loadProduitFromCsv() throws Exception{
        return new CsvToBeanBuilder<Produit>(
                new InputStreamReader(new ClassPathResource("produit.csv").getInputStream())
        )
                .withType(Produit.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build()
                .parse();

    }
}
