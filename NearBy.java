public class DistanceFinder {

	
	public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
	
	public static double calculateDistanceInKilometer(double userLat, double userLng, double targetLat, double targetLng) {

	    double latDistance = Math.toRadians(userLat - targetLat);
	    double lngDistance = Math.toRadians(userLng - targetLng);

	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	    			+ Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(targetLat))
	    			* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    return AVERAGE_RADIUS_OF_EARTH_KM * c;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("finding distance from roopena agrahara.....");
		
		System.out.println("\ndistance between R --> Elec : " 			+ calculateDistanceInKilometer(12.913367, 77.624627, 12.833797, 77.692862) + "Kms.");
		System.out.println("\ndistance between R --> silk board : "		+ calculateDistanceInKilometer(12.913367, 77.624627, 12.917858, 77.624524) + "Kms.");
		System.out.println("\ndistance between R --> indira nagar : " 	+ calculateDistanceInKilometer(12.913367, 77.624627, 12.971891, 77.641154) + "Kms.");
		System.out.println("\ndistance between R --> BSK : " 			+ calculateDistanceInKilometer(12.913367, 77.624627, 12.925453, 77.546757) + "Kms.");

	}

}
