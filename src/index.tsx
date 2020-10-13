import { NativeModules } from 'react-native';

type PincruxType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Pincrux } = NativeModules;

export default Pincrux as PincruxType;
