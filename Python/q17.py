#!/usr/bin/env python3

class PriorityQueue(object):
    def __init__(self):
        self.queue = []

    def __str__(self):
        return ' '.join([str(i) for i in self.queue])

    def isEmpty(self):
        return len(self.queue) == 0

    def insert(self, data, *args):
        self.queue.append(data)

        if args:
            try:
                self.queue = sorted(self.queue, key=args[0], reverse=args[1])
            except IndexError:
                self.queue = sorted(self.queue, key=args[0], reverse=False)
        else:
            self.queue = sorted(self.queue)

    def delete(self):
        try:
            max = 0
            item = self.queue[max]
            del self.queue[max]
            return item
        except IndexError:
            print()
            exit()


if __name__ == '__main__':
    myQueue = PriorityQueue()
    myQueue.insert("aa", len)
    myQueue.insert("ghhgjgj", len)
    myQueue.insert("bhla", len)
    myQueue.insert("z", len)
    print(myQueue)
    while not myQueue.isEmpty():
        print(myQueue.delete())
