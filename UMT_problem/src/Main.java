
public class Main {


        static boolean verificareAvg(int vectorA[], int n)
        {   double suma=0;
            double avg;
            for(int i=0;i<n;i++){
                suma=suma+vectorA[i];              // aici se calculeaza media aritmetica pentru vectorul referinta
            }
            avg=suma/n;

            int total = 1 << n;              // nr total de submultimi a vectorului 2^n

            for (int i = 0; i < total; i++) {   //se considera toate numerele de la 0 la 2^n-1
                double sumaMultime = 0;                 //dupa fiecare calcul de suma de submultime se reinitializeaza variabila cu 0


                for (int j = 0; j < n; j++)     //se foloseste reprezentarea binara a counter-ului de submultimi(i)
                    if ((i& (1<<j)) != 0)       // pentru a decide care numar sau numere sa fie alese
                       sumaMultime =sumaMultime+ vectorA[j];

                    for(int p=1;p<n;p++){           //daca exita posibilitatea ca media pentru p numere sa fie egala
                        if(avg*p==sumaMultime) return true; //cu ultima suma a submultimii calculate atunci vectorul
                                                    //se poate despartii in 2 vectori de medie egala
                    }
            }
            return false; // daca conditia nu este indeplinita se returneaza false
        }



        public static void main(String args[])
        {
            int vectorA[] = new int[] {1,2,3,4,5,6,7,8 }; //declararea vectorului
            int n = vectorA.length;             // lungimea vectorului
            System.out.println(verificareAvg(vectorA, n)); //apelarea functiei cu vectorul si lungimea acstuia


        }
    }



