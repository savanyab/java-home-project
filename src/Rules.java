import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame {

    public Rules() {
        setSize(620, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Játékszabályok");
        setLayout(new BorderLayout());
        String rules = "Cégvezető\n\n" +
                "A  játék egyszemélyes, egy kisebb, virtuális céget kell benne vezetni. \n" +
                "A cég kezdőtőkéje 1 000 000 Ft. A játéknak akkor van vége, ha a 2 000 000 forintos tőkét elértük.\n\nA játék körökre van osztva (egy kör egy hónapot jelent). \nMinden körben tetszőleges intézkedést rendelhetünk el a cégünkön.\n" +
                "\n" +
                "A cég szekrényeket készít el és forgalmaz, ehhez szükséges bútorlapokat és üveget beszerezni - \nezekből építhetjük össze a késztermékeket.\n" +
                "\n" +
                "Az elkészült termékekből mi rendelkezhetünk, hogy mennyit bocsátunk árusításra. \nKezdetben a termelékenység 0 egység bútor, \na későbbiekben egy dolgozó havonta 30 egységnyi bútort készít el.\n" +
                "\n" +
                "Nekünk kell gondoskodnunk az összes cégen belül zajló folyamatról. \n\nMinden körben lehetőségünk van a következő lépésekre:\n" +
                "\n- Nyersanyag vásárlása: \nMegadható, hogy mennyi egység nyersanyagot - bútorlapot és üveget -  vásárolunk. \nA nyersanyag bekerül a raktárunkba, a pénz levonásra kerül \n(arányosan mennyiségtől függően fizetünk).\n" +
                "\n\n" +
                "- Árucikk elkészítésének indítása: \nMegadjuk, mennyi árucikket szeretnénk gyártani. \nEgy egység szekrény elkészítéséhez egy egység üveg és két egység bútorlap kell. \nA következő hónapra elkészül a kívánt árucikk-mennyiség - maximum annyi, \namennyi a nyersanyagok mennyiségéből és az alkalmazottak számából adódóan előállítható.\n" +
                "\n" +
                "- Alkalmazottak számáról való döntés: \nEgy fő foglalkoztatása havonta 50 000 Ft-ös költséget jelent, \namit minden hónapban levonunk (amíg foglalkoztatjuk).\n" +
                "- Árucikk küldése eladásra:\n A raktárból kikerül az árucikk mennyiség, amennyit megadtunk. \nMinden hónapban véletlenszerűen generálódik az eladási arány. \nA következő hónapra megkapjuk az eladásból származó pénzösszeget. \nAz eladási ár legfeljebb az egy termék elkészítési árának 250%-a lehet.) \n" +
                "\n" +
                "- Reklám kérése/elvetése: \nMinél több reklámot kértünk a cégünkhöz, annál több árut tudunk eladni: \n5%-kal növeli a körönkénti véletlenszerű eladási arányt, (maximum 100%-ig). \nA reklám havonta pénzbe kerül. Ez minden hónapban automatikusan levonásra kerül. \n(Ahány reklám, annyiszor kell a reklám-díjat levonni)\n" +
                "\n" +
                "- Lépés a következő hónapra: \nA Jóváhagyás gomb lenyomásakor minden változtatás végrehajtódik a következő hónapra. \nIlyenkor készülnek el a feldolgozásra kiadott bútorok, ekkor adódnak el a termékek, \nautomatikusan levonásra kerülnek a bérek, a reklámokért kifizetendő összegek.\n";


        JTextArea textArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        setPreferredSize(new Dimension(500, 400));

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        textArea.setEditable(false);
        textArea.setText(rules);
        textArea.setBounds(10, 10, 280, 180);
    }
}
