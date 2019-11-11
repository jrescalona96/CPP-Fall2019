# Algorithm

## First Come First Serve

> - Traverse Whole File
> - Skip first line
> - Read and inititalize pageFrameSize
> - Traverse referenceString
> - create referenceString[ ] with page objs
> - Initialize frameVector page obj(s) until full
> - CheckPageFault() for next page obj
> - if true
> - increment pageFault
> - delete last page from frameVector
> - add page to front of frameVector
> - else
> - skip and next page
> - if end of referenceString[ ]
> - Read next String

## Last Recently Used
