import chalk from 'chalk';
import { Command } from 'commander';
import { App } from '../language-server/generated/ast';
import { ArduinoMlLanguageMetaData } from '../language-server/generated/module';
import { createArduinoMlServices } from '../language-server/arduino-ml-module';
import { extractAstNode } from './cli-util';
import { generateInoFile } from './generator';
import { NodeFileSystem } from 'langium/node';

export const generateAction = async (fileName: string, opts: GenerateOptions): Promise<void> => {
    const services = createArduinoMlServices(NodeFileSystem).ArduinoMl;
    const app = await extractAstNode<App>(fileName, services);
    const generatedFilePath = generateInoFile(app, fileName, opts.destination);
    console.log(chalk.green(`Arduino code generated successfully: ${generatedFilePath}`));
};

export type GenerateOptions = {
    destination?: string;
}

export default function(): void {
    const program = new Command();

    program
        // eslint-disable-next-line @typescript-eslint/no-var-requires
        .version(require('../../package.json').version);

    const fileExtensions = ArduinoMlLanguageMetaData.fileExtensions.join(', ');
    program
        .command('generate')
        .argument('<file>', `source file (possible file extensions: ${fileExtensions})`)
        .option('-d, --destination <dir>', 'destination directory of generating')
        .description('generates JavaScript code that prints "Hello, {name}!" for each greeting in a source file')
        .action(generateAction);

    program.parse(process.argv);
}
