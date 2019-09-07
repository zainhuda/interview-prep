import java.util.LinkedList;

public class Solution {
    class Sector {
        int row;
        int col;
        public Sector(int row, int col) { 
            this.row = row;
            this.col = col;
        }
        public String toString() {
            String r = String(this.row);
            String c = String(this.col);
            return r + c + ".jpg";
        }
    }

    class Node {
        Sector sec;
        Node prev;
        Node next;
        public Node(Sector sec) {
            this.sec = sec;
            prev = null;
            next = null;
        }
    }

   

    class Panorama  {
        int maxRow;
        int maxCols;
        HashMap<Sector, Node> cache;
        Node head;
        Node tail;
        public Panorama(int rows, int cols) {
            this.maxRow = rows;
            this.maxCols = cols;
            this.cache = new HashMap<>();
            head = new Node(null);
            tail = new Node(null);
            head.next = tail;
            tail.prev = head;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Sector sec = new Sector(i, j);
                    Node node = new Node(sec);
                    cache.put(sec, node);
                    node.next = head.next;
                    head.next.prev = node;
                    head.next = node;
                    node.prev = head;
                }
            }
        }

        public void update(Sector sector, String image) {
            if (sector.row > maxRow || sector.row < 0 || sector.col > maxCols || sector.col < 0) throw new IllegalArgumentException();
            String fileName = sector.toString(); 
            // write to disk
            save(fileName, image);
            Node ret = cache.get(sector);
            ret.prev.next = ret.next;
            ret.next.prev = ret.prev;
            head.next.prev = ret;
            ret.next = head.next;
            head.next = ret;
            ret.prev = head;
        }

        public Image fetch(Sector sector) {
            // some java method to find the file
            if (sector.row > maxRow || sector.row < 0 || sector.col > maxCols || sector.col < 0) throw new IllegalArgumentException();
            return file(sector.toString());
        }

        public Sector leastRecentlyUpdated() {
            return this.tail.prev;
        }
    }
}