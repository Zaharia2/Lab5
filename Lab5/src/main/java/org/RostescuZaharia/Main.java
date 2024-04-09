package org.RostescuZaharia;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<PerecheNumere> lista =new ArrayList<PerecheNumere>();
        lista=citire();
        for (PerecheNumere p : lista)
        {
            System.out.println(p.toString()+"\n");
        }
        scriere(lista);
    }

    public static void scriere(List <PerecheNumere> lista) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        File file=new File("C:\\Users\\roste\\Desktop\\Lab5\\Lab5\\src\\main\\resources\\numere.json");
        if(file.exists())
            mapper.writeValue(file,lista);
        else System.out.println("nu e bine(");
    }

    public static List<PerecheNumere> citire()
    {
        try {
            File file=new File("C:\\Users\\roste\\Desktop\\Lab5\\Lab5\\src\\main\\resources\\numere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> lista = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}