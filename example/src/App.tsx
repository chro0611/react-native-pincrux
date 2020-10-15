import * as React from 'react';
import { StyleSheet, View, Button, ScrollView } from 'react-native';
import RNPincrux from 'pincrux';

export default function App() {
  return (
    <ScrollView style={styles.container}>
      <View style={styles.height500}>
        <RNPincrux
          user="test"
          style={styles.height500}
          height={500}
        />
      </View>
      <View>
        <Button onPress={() => console.log('test')} title={'Test0'} />
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  height500: {
    height: 500,
  },
});
