package sheet4.apple;

public class TestApfelpresse {
	public static void main(String[] args) {
		
		// Kanister = 200
		Apfelpresse apresse = new Apfelpresse(50);
		// Gewicht=200g, Flüssigkeitsanteil=60%
		apresse.presse(new Apfel(200, 0.6));
		apresse.presse(new Apfel(50, 0.7));
		// Liefert die gesamte bisher produzierte Apfelsaftmenge
		double saftMenge = apresse.getTotalApfelsaft();
		// Menge ist hier 0.155 Liter
		System.out.println("Apfelsaftproduktion gesamt: " + saftMenge);
		apresse.presse(new Apfel(70000, 0.8));
		saftMenge = apresse.getTotalApfelsaft();
		// Menge ist hier 50.0 Liter
		System.out.println("Apfelsaftproduktion gesamt: " + saftMenge);

		// Kanister wird geleert
		double apfelSaftMenge = apresse.leereKanister();
		saftMenge = apresse.getTotalApfelsaft();
		// Menge ist hier 0.0 Liter
		System.out.println("Apfelsaftproduktion gesamt: " + saftMenge);
	}
}