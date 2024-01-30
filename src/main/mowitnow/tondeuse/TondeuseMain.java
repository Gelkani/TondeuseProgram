package main.mowitnow.tondeuse;

import main.mowitnow.tondeuse.entities.ParamsTondeuse;
import main.mowitnow.tondeuse.exception.ExceptionTondeuse;
import main.mowitnow.tondeuse.parserUtilities.ParserTondeuse;
import main.mowitnow.tondeuse.service.FormatLine;
import main.mowitnow.tondeuse.service.TreatmentPelouse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TondeuseMain {
    protected static List<String> resList;

    public static void main(String... args) throws ExceptionTondeuse, IOException {
        if (args.length == 1) {
            File file = new File(args[0]);
            TondeuseMain instance = new TondeuseMain();
            resList = instance.loadTreatmentTondeuse(file);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<String> loadTreatmentTondeuse(File file) throws ExceptionTondeuse, IOException {
        if(!file.isFile()){
            throw new ExceptionTondeuse((ParamsTondeuse.ERROR_FILE_NOT_EXISTENT));
        } else {
            ParserTondeuse parser = new ParserTondeuse();
            try (Scanner scanner = new Scanner(file)) {
                treatFirstLine(parser, scanner);
                return treatNextLines(parser, scanner);
            }
        }

    }

    protected void treatFirstLine(ParserTondeuse parser, Scanner scanner)
            throws ExceptionTondeuse {
        if (scanner.hasNext()) {
            parser.setPelouse(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new ExceptionTondeuse(
                    ParamsTondeuse.ERROR_WRONG_DATA);
        }
    }
    private List<String> treatNextLines(ParserTondeuse parser,
                                                Scanner scanner) throws ExceptionTondeuse {
        List<String> listPositions = new ArrayList<>();
        while (scanner.hasNext()) {
            parser.setTondeuse(scanner.nextLine());
            if (scanner.hasNext()) {
                parser.setInstructions(scanner.nextLine());
                listPositions.add(parseLoadTreatment(parser));
            } else {
                throw new ExceptionTondeuse(ParamsTondeuse.ERROR_WRONG_DATA);
            }
        }
        return listPositions;
    }
   private String parseLoadTreatment(ParserTondeuse parser) throws ExceptionTondeuse{
       if (!parser.executeParse()) {
           throw new ExceptionTondeuse(ParamsTondeuse.ERROR_WRONG_DATA);
       } else {
           TreatmentPelouse treatment = new TreatmentPelouse();
           treatment.setPelouse(FormatLine
                   .formatLinePelouse(parser.getPelouse()));
           treatment.setPositionTondeuse(FormatLine
                   .formatLineTondeuse(parser.getTondeuse()));
           treatment.setListInstruction(FormatLine
                   .formatLineInstruction(parser.getInstructions()));
           treatment.executeInstructions();
           System.out.println(treatment);
           return treatment.toString();
       }
   }
}
