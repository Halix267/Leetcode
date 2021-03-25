import java.util.*;
class TestClass {

   static  class edge
    {
        int a;
        int b;
        int w;
    }
    static class ABC implements Comparator<edge>{
            
            public int compare(edge a,edge b){

                if(a.w>b.w){
                    return 1;
                }else if(a.w==b.w) return 0;
                else return -1;
            }
        }
    static List<edge> arr= new ArrayList<>();
    static int par[] = new int[100001];
    public static void main(String args[] ) throws Exception {
       
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=1;i<=n;i++){
            par[i]=-1;
        }
        for(int i=0;i<m;i++){

            edge temp = new edge();
            temp.a = sc.nextInt();
            temp.b = sc.nextInt();
            temp.w = sc.nextInt();
            arr.add(temp);

        }

       
        ABC comp = new ABC();
        Collections.sort(arr,comp);
        /*
        for(int i=0;i<m;i++){
           System.out.println(arr.get(i).w);
       }*/
        //System.out.println("111");
        int sum=0;
        for(int i=0;i<m;i++){
            
            int a = find(arr.get(i).a);
            int b = find(arr.get(i).b);
            
            if(a!=b){
                sum+=arr.get(i).w;
                union(a,b);
            }
        }
        System.out.println(sum);

    }
    
    static int find(int a){
        if(par[a]<0)return a;
        
        return par[a]=find(par[a]);
    }
    
    static void union(int a,int b){
        par[a]=b;
    }
    
    
}
