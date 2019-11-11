# **Algorithms**

## **First Come First Serve**

> - let n = Number of page frame
> - while not end file
> > - read referenceString
> > - while not end of string
> > - read char
> > - initialize Queue with N chars
> > - Check Page fault
> > - if true
> > > - pop from tableQueue
> > > - push to tableQueue
> > - else skip
> - read next char

## **Least Recently Used**
> - let n = Number of page frame
> - while not end file
> > - read referenceString
> > - while not end of string
> > - read char
> > - initialize Queue with N chars
> > - Check Page fault
> > - if true
> > - pop from tableQueue
> > - push to tableQueue
> > - else (everytime there is a page hit, move that element to end of queue)
> > - while tableQueue is not empty
> > > - if page != element at top front of queue
> > > - pop element and push to stack
> > > - else pop element
> > - push elements from stack to tableQueue
> > - push page to tableQueue
> - read next char

## **Optimal**
> - let n = Number of page frame
> - while not end file
> > - read referenceString
> > - while not end of string
> > - read char
> > - initialize Queue with N chars
> > - Check Page fault
> > - if true
> > - pop from tableQueue
> > - push to tableQueue
> > - else (everytime there is a page hit, move that element to end of queue)
> > - while tableQueue is not empty
> > > - if page != element at top front of queue
> > > - pop element and push to stack
> > > - else pop element
> > - push elements from stack to tableQueue
> > - push page to tableQueue
> - read next char