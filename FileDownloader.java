class FileDownloader implements Runnable {
    private volatile boolean downloadCancelled = false;

    public void cancelDownload() {
        downloadCancelled = true;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if (downloadCancelled) {
                    System.out.println("Download cancelled. Cleanup resources and exit.");
                    return;
                }

                // Simulate downloading a portion of the file
                System.out.println("Downloading part " + i);
                TimeUnit.SECONDS.sleep(1);
            }

            System.out.println("Download complete.");
        } catch (InterruptedException e) {
            // Handling interruption and cleaning up (if necessary)
            System.out.println("Thread has been interrupted. Cleanup resources and exit.");
        }
    }
}