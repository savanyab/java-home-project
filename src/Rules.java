import javax.swing.*;
import java.awt.*;

public class Rules extends JFrame {

    public Rules() {
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        String rules = "Cégvezető\n" +
                "A  játék egyszemélyes, egy kisebb, virtuális céget kell benne vezetni. A játék körökre van osztva (egy kör egy hónapot jelent). Minden körben tetszőleges intézkedést rendelhetünk el a cégünkön.\n" +
                "\n" +
                "A cég szekrényeket készít el és forgalmaz, ehhez szükséges bútorlapokat és üveget beszerezni - ezekből építhetjük össze a késztermékeket.\n" +
                "\n" +
                "A cég kezdőtőkéje 1 000 000 Ft. A játéknak akkor van vége, ha az 2 000 000 forintos tőkét elértük.\n" +

                "Az elkészült termékekből mi rendelkezhetünk, hogy mennyit bocsátunk árusításra. Kezdetben a termelékenység 0 egység bútor, a későbbiekben egy dolgozó havonta 30 egységnyi bútort készít el.\n" +
                "\n" +
                "Nekünk kell gondoskodnunk az összes cégen belül zajló folyamatról. Minden körben lehetőségünk van a következő lépésekre:\n" +
                "- Nyersanyag vásárlása: Megadható, hogy mennyi egység nyersanyagot - bútorlapot és üveget -  vásárolunk. A nyersanyag bekerül a raktárunkba, a pénz levonásra kerül (arányosan mennyiségtől függően fizetünk).\n" +
                "\n" +
                "- Árucikk elkészítésének indítása: Megadjuk, mennyi árucikket szeretnénk gyártani. Egy egység szekrény elkészítéséhez egy egység üveg és két egység bútorlap kell. A következő hónapra elkészül a kívánt árucikk-mennyiség - maximum annyi, amennyi a nyersanyagok mennyiségéből és az alkalmazottak számából adódóan előállítható.\n" +
                "\n" +
                "- Új alkalmazott felvétele/kirúgása: Ez havonta 50 000 Ft-ös költséget jelent, amit minden hónapban levonunk (amíg foglalkoztatjuk). Viszont ha új alkalmazottat veszünk fel, a termelékenység megnő 30 egység bútorral.\n" +
                "- Árucikk küldése eladásra: A raktárból kikerül az árucikk mennyiség, amennyit megadtunk. Minden hónapban véletlenszerűen generálódik az eladási arány. A következő hónapra megkapjuk az eladásból származó pénzösszeget. Az eladási ár legfeljebb az egy termék elkészítési árának 250%-a lehet.) \n" +
                "\n" +
                "- Reklám kérése/elvetése: Minél több reklámot kértünk a cégünkhöz, annál több árut tudunk eladni: 5%-kal növeli a körönkénti véletlenszerű eladási arányt, addig, míg 100%-hoz érünk. A reklám havonta pénzbe kerül. Ez minden hónapban automatikusan levonásra kerül. (ahány reklám, annyiszor kell a reklám-díjat levonni)\n" +
                "\n" +
                "- Lépés a következő hónapra: A Jóváhagyás gomb lenyomásakor minden változtatás végrehajtódik a következő hónapra. Ilyenkor készülnek el a feldolgozásra kiadott bútorok, ekkor adódnak el a termékek, automatikusan levonásra kerülnek a bérek, a reklámokért kifizetendő összegek.\n";
        JPanel contentPane = new JPanel();
        JTextArea textArea = new JTextArea(20, 10);
        JScrollPane scrollPane = new JScrollPane(textArea);

        textArea.setEditable(false);

        textArea.setText(rules);
        

        contentPane.setPreferredSize(new Dimension(400, 100));

        contentPane.add(scrollPane, BorderLayout.CENTER);

        add(contentPane);
    }
}
