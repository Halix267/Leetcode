
import java.io.*;

import java.util.*;

class ques
{
	public static void main(String[] args)throws Exception{ new ques().run();} 
	long mod=1000000000+7;
	
	
	
	int cc_count=0;
	int dist[] = new int[10001];
	void solve() throws Exception
	{
		int t =ni();
		Arrays.fill(prime,1);
		isPrime();
		for(int tt=1;tt<=t;tt++) {
			
		    
			int a = ni();
			int b = ni();
			
        	int[] vis = new int[10001];
        	
			
			List<List<Integer>> l =new ArrayList<>();
			
			for(int i=0;i<=10000;i++) {
				
				l.add(new ArrayList<>());
			}
			
			buildGraph(l);
			
			
			Arrays.fill(dist,-1);
			//out.println(l);
			bfs(a,l,vis);
			
			if(dist[b]==-1) out.println("Impossible");
			else out.println(dist[b]);
		
			
			
			
		}
		
		
	}
	List<Integer>primes = new ArrayList<>();
	int[] prime = new int[10001];
	
	void isPrime() {
	    
		for(int i=2;i*i<=10000;i++) {
			
			if(prime[i]==1){
    			for(int j=i*i;j<=10000;j+=i){
    			    prime[j]=0;
    			}
			}
		}
		
	}
	
	boolean isValid(int a,int b) {
		int cnt=0;
		while(a>0) {
			
			if((a%10)!=(b%10))cnt++;
			a/=10;
			b/=10;
		}
		return cnt==1?true:false;
	}
	void buildGraph(List<List<Integer>> l) {
		
		for(int i=1000;i<=9999;i++) {
			
			if(prime[i]==1) {
				primes.add(i);
			}
		}
		
		for(int i=0;i<primes.size();i++) {
			
			for(int j=i+1;j<primes.size();j++) {
				int a = primes.get(i);
				
				int b = primes.get(j);
				
				if(isValid(a,b)) {
					l.get(a).add(b);
					l.get(b).add(a);
				}
			}
		}
	}
	/*
	boolean dfs(int v,List<List<Integer>> l,int[] vis,int[] col) {
		
		vis[v]=1;
		//dist[v]=d;
		cc_count++;
		
		for(int child:l.get(v)) {
			if(vis[child]==0) {
				dfs(child,l,vis,col);
			}
		
		}
		
	}*/
	
	void bfs(int v,List<List<Integer>> l,int[] vis) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		
		vis[v]=1;
		dist[v]=0;
		
		while(!q.isEmpty()) {
			
			int node = q.poll();
			
			for(int child:l.get(node)) {
				if(vis[child]==0) {
					
					q.add(child);
					dist[child] = dist[node]+1;
					vis[child]=1;
				}
			}
			
		}
	}
	
	
	
	
	/*FAST INPUT OUTPUT & METHODS BELOW*/
	
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	private SpaceCharFilter filter;
	PrintWriter out;
	
	int min(int... ar){int min=Integer.MAX_VALUE;for(int i:ar)min=Math.min(min, i);return min;}
	long min(long... ar){long min=Long.MAX_VALUE;for(long i:ar)min=Math.min(min, i);return min;}
	int max(int... ar) {int max=Integer.MIN_VALUE;for(int i:ar)max=Math.max(max, i);return max;}
	long max(long... ar) {long max=Long.MIN_VALUE;for(long i:ar)max=Math.max(max, i);return max;}
	
	void shuffle(int a[]) {
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<a.length;i++) 
			al.add(a[i]);
		
		Collections.sort(al);
		for(int i=0;i<a.length;i++) 
			a[i]=al.get(i);
	}
	long lcm(long a,long b)
	{
		return (a*b)/(gcd(a,b));
	}
	
	int gcd(int a, int b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b%a, a); 
	} 
	long gcd(long a, long b) 
	{ 
		if (a == 0) 
			return b; 
		return gcd(b%a, a); 
	}
	/* for (1/a)%mod = ( a^(mod-2) )%mod  ----> use expo to calc -->(a^(mod-2)) */
	long expo(long p,long q)  /*  (p^q)%mod   */
	{
		long z = 1;
		while (q>0) {
			if (q%2 == 1) {
				z = (z * p)%mod;
			}
			p = (p*p)%mod;
			q >>= 1;
		}
		return z;
	}
	void run()throws Exception
	{
		in=System.in; out = new PrintWriter(System.out);
		solve();
		out.flush();
	}
	private int scan()throws IOException
	{
		if(total<0)
			throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
				return -1;
		}
		return buf[index++];
	}
	private int ni() throws IOException 
	{
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = scan();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = scan();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	private long nl() throws IOException 
	{
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = scan()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = scan();
		}
		
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = scan();
		}
	}
	private double nd() throws IOException{
		return Double.parseDouble(ns());
	}
	private String ns() throws IOException {
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		StringBuilder res = new StringBuilder();
		do {
			if (Character.isValidCodePoint(c))
				res.appendCodePoint(c);
			c = scan();
		} while (!isSpaceChar(c));
		return res.toString();
	}
	private String nss() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	private char nc() throws IOException 
	{
		int c = scan();
		while (isSpaceChar(c))
			c = scan();
		return (char) c;
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
			return true;
		return false;
	}
	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhiteSpace(c);
	}
	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
