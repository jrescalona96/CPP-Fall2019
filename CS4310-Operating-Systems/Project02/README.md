## **First Come First Serve**
> - let n = Number of page frame
> - while not end file
> >  - read referenceString
> >  - while not end of string
> >  - read char
> >  - initialize Queue with N chars
> >  - Check Page fault
> >  - if true
> >  >  - pop from pageTable & push page to end
> >  - else skip
> - read next char

## **Least Recently Used**
> - let n = Number of page frame
> - while not end file
> > - read referenceString
> > - while not end of string
> > - read char
> > - if length of pageTable < N
> - if no page fault, skip
> > > - else add page to end
> > - Check Page fault
> > - if true
> > - pop from tableQueue
> > - push to tableQueue
> > - else (everytime there is a page hit, move that element to end of queue)
> > - while tableQueue is not empty
> > >  - if page != element at top front of queue
> > >  - pop element and push to end
> > >  - else pop element
> > - push elements from stack to tableQueue
> > - push page to tableQueue
> - read next page

## **Optimal**
> - let N = Number of page frame
> - while not end file
>  > - read referenceString
>  > - while not end of string
>  > - read char
>  > - initialize pageTable with N characters keeping
>  > - if length of pageTable < N
> > - if no page fault, skip
> > - else add page to end
>  > - Check Page fault
>  > - if true
>  > - pop from front and push to end of push to tableQueue
>  > - else rearrange Queue so that optimal page to remove is on top
>  > - while not end of page table
>  >  > - if page in pageTable not in remaining reference string, skip
>  >  > - else get index
>  >  >  - if index is current max index, set optimal page
>  >  >  - else skip
>  > - update pageTable with optimal page up front
> - read next page

## Run File
To run the file, you can use the *run.sh* with proper permissions set.
OR
```javac <filename>.java```
```java <filename> <page_frame_size>```