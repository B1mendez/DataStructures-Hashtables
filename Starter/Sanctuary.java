/**
 * TODO: Complete the solution for Sanctuary
 */
import java.util.HashMap;
import java.util.Set;

public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    public Sanctuary(int maxAnimals, int maxSpecies) {
        if (maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException(); 
        }
        
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies; 
        sanctuary = new HashMap<>(); 
    }

    public int getNum(String species) {
        if (species == null){
            throw new IllegalArgumentException(); 
        }

        if (sanctuary.containsKey(species)){
            return sanctuary.get(species); 
        }
    
        return 0;
    }
    
    public int getTotalAnimals() {
        int count = 0; 
        for (String key: sanctuary.keySet()){
            count = count + sanctuary.get(key); 
        }
        return count;
    }
    
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    public int rescue(String species, int num) {
        if (num <= 0 || species == null){
            throw new IllegalArgumentException(); 
        }

        int animalCount = 0; 
        int notRescued = 0; 
        if (this.maxSpecies > getTotalSpecies() || this.maxAnimals > getTotalAnimals()){
            animalCount = getTotalAnimals() + num;

            if (animalCount > this.maxAnimals) {
                notRescued = animalCount - this.maxAnimals; 
                sanctuary.put(species, num - notRescued);
            } 
            else {
                sanctuary.put(species, num); 
            }
        }
        return notRescued;
    }

    public void release(String species, int num) {
        if (num <= 0 || species == null 
            || !sanctuary.containsKey(species) || sanctuary.get(species) < num){
            throw new IllegalArgumentException(); 
        }

        sanctuary.put(species, sanctuary.get(species) - num); 
        if (sanctuary.get(species) == 0 ){
            sanctuary.remove(species); 
        }
    }
}
