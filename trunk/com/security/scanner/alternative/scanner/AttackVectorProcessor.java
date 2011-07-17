package com.security.scanner.alternative.scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttackVectorProcessor {

    File attackVectorFile;
    List<String> listOfAttackVectors = new ArrayList<String>();


    public AttackVectorProcessor (File attackVectorFile)
    {
        this.attackVectorFile = attackVectorFile;
    }

    public List<String> getAttackVectorsFromFile ()
    {
        try
        {
        LineIterator lineIterator = FileUtils.lineIterator(attackVectorFile);
        while (lineIterator.hasNext())
        {
            listOfAttackVectors.add(lineIterator.nextLine());
        }
        } catch (IOException ioe)
        {
            System.out.println(ioe);
        }

        return listOfAttackVectors;
    }
}
