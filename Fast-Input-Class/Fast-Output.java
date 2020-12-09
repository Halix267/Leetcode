OutputStream out = new BufferedOutputStream ( System.out );
for (int i = 0; i < N; i++) {
    out.write((a[i] + " ").getBytes());
    }
          
out.flush();
