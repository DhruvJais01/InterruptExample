class Main {
  public static void main(String[] args) {
    FileDownloader downloader = new FileDownloader();
    Thread downloadThread = new Thread(downloader);

    // Start the download thread
    downloadThread.start();

    // Simulate user cancelling the download after 5 seconds
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Interrupt the download thread to signal cancellation
    // downloadThread.interrupt();
    // Download cancel 
    downloader.cancelDownload();
  }
}