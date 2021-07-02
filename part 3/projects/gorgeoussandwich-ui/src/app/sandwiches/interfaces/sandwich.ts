import {Designation} from './designation';
import {Description} from './description';
import {Type} from './type';

export interface Sandwich {
  sandwichId: number;
  designation: Designation;
  description: Description;
  type: Type;
}
