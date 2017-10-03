To build and run the code, you will require maven and also for 'mvn' to be in your path.

You will also require a ruby interpreter to execute the 'run' script

To build and run the code after ensuring the prior pre-requisites are fulfilled.

please execute the 'run' script and follow the instructions.

Assumptions made:

1) There is only one event in each location

2) There is currently no functionality to add or remove tickets from events.

3) There were no time constraints on any of the events

4) Events are unique

How might you change your program if you needed to support multiple events at the
same location?

I would create a separate object called Location which will hold a list of events.

Since all of the events at that location have the same manhattan distance, I would either return the cheapest event
at that location or return all of the events at that location depending on the specification.

How would you change your program if you were working with a much larger world
size?

Currently I iterate over the whole grid and compute the manhattan distance for all the events. Since the grid
is relatively small, this is a fast operation. However, if the world were much larger then instead of searching the whole
grid I would restrict my search space.

I would essentially search a smaller grid around a specific point.

For example if my world was a grid of size 1000 by 1000 and my point of interest was the point (0, 0)
then instead of searching the whole grid, I would search a grid of 100 by 100 around the point (0, 0).

To add this modification, all I would need to do is compute the relevant start and end co-ordinates and iterate over all
the points in that grid.











