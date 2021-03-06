public class Levenshtein {

/*public static void main(String[] args) {
    if (args.length !=2)
      System.out.println("Uso: java Levenshtein <cadena1> <cadena2>");
    else {
      System.out.println(computeLevenshteinDistance(args[0], args[1]));
    }
}*/

public static int computeLevenshteinDistance(String str1, String str2) {
	int[][] distance = new int[str1.length()+1][];
	int repi, repj;

	for(int i=0; i<=str1.length(); i++){
		distance[i] = new int[str2.length()+1];
		distance[i][0] = i;
	}

	for(int j=0; j<str2.length()+1; j++)
		distance[0][j]=j;

	for  (int i=1 ; i <= str1.length() ; i++)
		for(int j=1 ; j <= str2.length() ; j++) {
			distance[i][j]= minimum(
                              distance[i-1][j]  +1,
									            distance [i] [j-1]+1,
									            distance[i-1][j-1]+((str1.charAt(str1.length()-i) == str2.charAt(str2.length()-j)) ? 0 : 1)
                      );
		}

	return distance[str1.length()][str2.length()];
}

private static int minimum(int a, int b, int c){
		if (a<=b && a<=c)
			return a;
		if (b<=a && b<=c)
			return b;
		return c;
}

}
