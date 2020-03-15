public class Dictionary {
    private int capacity;
    private int count;
    private KVEntry[] entries;

    public Dictionary(int capacity)
    {
        this.capacity = capacity;
        entries = new KVEntry[capacity];
        count = 0;
    }

    private int hashFunction(int key)
    {
        return key % capacity;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean contains(int key)
    {
        if (count == 0)
            return false;
        int hashKey = hashFunction(key);
        KVEntry ptr = entries[hashKey];
        while (ptr != null)
        {
            if (ptr.key == key)
                return true;
            ptr = ptr.next;
        }
        return false;
    }

    public boolean remove(int key)
    {
        int hashKey = hashFunction(key);
        KVEntry ptr = entries[hashKey];
        KVEntry pNewNode = null;
        while (ptr != null)
        {
            if (ptr.key == key)
            {
                if (pNewNode != null) {
                    pNewNode.next = ptr.next;
                }
                else if (ptr.next != null) //first but not only node, reassigns node to match next one and then skips next
                {
                    ptr.key = ptr.next.key;
                    ptr.value = ptr.next.value;
                    ptr.next = ptr.next.next;
                }
                else //first and only value
                {
                    entries[hashKey] = null;
                }
                count--;
                return true;
            }
            pNewNode = ptr;
            ptr = ptr.next;
        }
        return false;
    }

    public int get(int key)
    {
        int hashKey = hashFunction(key);
        KVEntry ptr = entries[hashKey];
        while (ptr != null)
        {
            if (ptr.key == key)
                return ptr.value;
            ptr = ptr.next;
        }
        return -1;
    }

    public int getCount()
    {
        return count;
    }

    public boolean add(int key, int value)
    {
        int hashedKey = hashFunction(key);

        if (entries[hashedKey] == null)
        {
            if (count == capacity)
                return false;
            entries[hashedKey] = new KVEntry(key, value);
            count++;
            return true;
        }

        KVEntry ptr = entries[hashedKey];
        KVEntry pNewNode = null;
        while (ptr != null)
        {
            if (ptr.key == key)
            {
                ptr.value = value;
                return true;
            }
            pNewNode = ptr;
            ptr = ptr.next;
        }
        pNewNode.next = new KVEntry(key, value);
        return true;
    }
}