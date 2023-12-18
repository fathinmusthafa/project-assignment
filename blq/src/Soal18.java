public class Soal18 {
    public static void main(String[] args) {

        int[] eatTime = {9, 13, 15, 17};
        int[] calories = {30, 20, 50, 80};
        int startWorkout = 18;
        int diff;
        double workoutTime = 0;

        for (int i = 0; i < eatTime.length; i++) {
            diff = startWorkout - eatTime[i];
            workoutTime += 0.1*calories[i]*diff;
        }

        int drinkWater = 500;
        if (workoutTime > 30) {
            drinkWater += (int) (100 * Math.floor(workoutTime / 30));
        }

        System.out.println("Air yang diminum: "+ drinkWater + " cc");
    }
}
