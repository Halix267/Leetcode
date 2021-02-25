    
# n is the no of edges


List<List<Integer>> l =  new ArrayList<>();
    int n = ni();
		
		for(int i=0;i<n;i++) {
			
			l.add(new ArrayList<>());
		}
		
		
		while(n-->0) {
			
			int a = ni();
			int b = ni();
			l.get(a).add(b);
			l.get(b).add(a);
  
		}
