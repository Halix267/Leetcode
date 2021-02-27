int maxD =-1,maxNOde=0;
int vis[] = new int[1000001];
void dfs(int v,int d) {
		
		vis[v]=1;
		if(d>maxD)maxD=d; maxNode =v;
		
		for(int child:l.get(v)) {
			if(vis[child]==0)
			dfs(child,d+1);
		}
	}


main(){
  
  
  maxD=-1;
  dfs(1,0);
  
  Arrays.fill(vis,0);
  
  maxD=-1;
  dfs(maxNode,0);
  
  out.println(maxD);
  
  
}


	
