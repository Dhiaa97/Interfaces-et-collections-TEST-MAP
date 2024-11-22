import org.example.Departement;
import org.example.Employe;
import org.example.InterfaceSociete;

import java.util.HashMap;
import java.util.Map;

public class SocieteHashMap implements InterfaceSociete {
    private Map<Employe, Departement> employeDepartement = new HashMap<>();

    @Override
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        employeDepartement.put(e, d);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        employeDepartement.remove(e);
    }

    @Override
    public void afficherLesEmployesLeursDepartements() {
        employeDepartement.forEach((e, d) ->
                System.out.println(e + " appartient au département " + d));
    }

    @Override
    public void afficherLesEmployes() {
        employeDepartement.keySet().forEach(System.out::println);
    }

    @Override
    public void afficherLesDepartements() {
        employeDepartement.values().stream().distinct().forEach(System.out::println);
    }

    @Override
    public void afficherDepartement(Employe e) {
        Departement d = employeDepartement.get(e);
        if (d != null) {
            System.out.println("Employé " + e + " appartient au département " + d);
        } else {
            System.out.println("Employé non trouvé.");
        }
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return employeDepartement.containsKey(e);
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return employeDepartement.containsValue(d);
    }
}
